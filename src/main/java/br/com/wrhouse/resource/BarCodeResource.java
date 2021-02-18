package br.com.wrhouse.resource;

import br.com.wrhouse.model.PayloadFileWrapper;
import br.com.wrhouse.service.CodeService;
import br.com.wrhouse.util.FileUtil;
import com.google.zxing.NotFoundException;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("code") @Log
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BarCodeResource {

    @Inject
    CodeService codeService;

    @POST
    public Response receiveImage(PayloadFileWrapper payload) throws IOException, NotFoundException {
        codeService.readBarCode(payload.getBase64());

        return Response.status(Response.Status.CREATED).build();
    }
}
