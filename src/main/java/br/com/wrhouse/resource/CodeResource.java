package br.com.wrhouse.resource;

import br.com.wrhouse.model.Code;
import br.com.wrhouse.repository.CodeRepository;
import lombok.extern.java.Log;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("codes") @Log
public class CodeResource {

    @Inject
    CodeRepository codeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Code> all() {
        return codeRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Code code) {
        codeRepository.persist(code);
        return Response.status(Response.Status.CREATED).build();
    }

}
