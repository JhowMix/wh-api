package br.com.wrhouse.service;

import br.com.wrhouse.model.City;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("estados")
@RegisterRestClient
public interface CityService {

    @GET
    @Path("{uf}/municipios")
    List<City> getCityByUF(@PathParam String uf);
}
