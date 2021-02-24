package br.com.wrhouse.resource;

import br.com.wrhouse.model.Image;
import br.com.wrhouse.model.Item;
import br.com.wrhouse.repository.ImageRepository;
import br.com.wrhouse.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.ext.web.multipart.MultipartForm;
import lombok.extern.java.Log;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@Path("itens") @Log
public class ItemResource {

    @Inject
    ItemRepository itemRepository;

    @Inject
    ImageRepository imageRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> all() {
        return itemRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Item item) {
        item.setCreatedAt(LocalDateTime.now());
        itemRepository.persist(item);
        return Response.status(Status.CREATED).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response save(MultipartFormDataInput multipart) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        byte[] itemRaw = IOUtils.toByteArray(
                multipart.getFormDataMap()
                        .get("item")
                        .get(0)
                        .getBody(InputStream.class, null));

        Item item = objectMapper.readValue(new String(itemRaw, StandardCharsets.UTF_8), Item.class);

        List<InputPart> inputPars = multipart.getFormDataMap().get("files");


        inputPars.forEach(inputPart -> {
            try (InputStream inputStream = inputPart.getBody(InputStream.class, null)) {
                byte[] data = IOUtils.toByteArray(inputStream);

                Image image = new Image();
                image.setTitle("item_" + LocalDateTime.now().getNano());
                image.setDetails("Imagem demonstrativa do item");
                image.setData(data);

                imageRepository.persist(image);
                item.getImages().add(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        itemRepository.persist(item);

        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Item item) {
        itemRepository.updateWithSync(item);
        return Response.status(Status.ACCEPTED).build();
    }
}
