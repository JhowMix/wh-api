package br.com.wrhouse.resource;

import br.com.wrhouse.model.Item;
import br.com.wrhouse.repository.ItemRepository;
import lombok.extern.java.Log;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.time.LocalDateTime;
import java.util.List;

@Path("itens") @Log
public class ItemResource {

    @Inject
    ItemRepository itemRepository;

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

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Item item) {
        itemRepository.updateWithSync(item);
        return Response.status(Status.ACCEPTED).build();
    }
}
