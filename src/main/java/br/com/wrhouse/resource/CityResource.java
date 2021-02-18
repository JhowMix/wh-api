package br.com.wrhouse.resource;

import br.com.wrhouse.model.City;
import br.com.wrhouse.repository.CityRepository;
import lombok.extern.java.Log;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cities") @Log
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    @Inject
    CityRepository cityRepository;

    @GET
    public List<City> all() {
        return cityRepository.listAll();
    }

    @GET
    @Path("uf/{code}")
    public List<City> byUF(@PathParam("code") String code) {
        return cityRepository.getByUF(code);
    }
}
