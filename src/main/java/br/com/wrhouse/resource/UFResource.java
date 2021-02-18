package br.com.wrhouse.resource;

import br.com.wrhouse.model.UF;
import br.com.wrhouse.repository.UFRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ufs")
public class UFResource {

    @Inject
    UFRepository ufRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UF> all() {
        return ufRepository.listAll();
    }

    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public UF findOne(@PathParam String code) {
        return ufRepository.find("code", code).firstResult();
    }
}
