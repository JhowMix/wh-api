package br.com.wrhouse.resource;

import br.com.wrhouse.model.Address;
import br.com.wrhouse.repository.AddressRepository;
import br.com.wrhouse.service.ViaCEPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.java.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("addresses") @Log
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    @RestClient
    ViaCEPService viaCEPService;

    @Inject
    AddressRepository addressRepository;

    @GET
    @Path("{cep}/location")
    public Response getLocationByCEP(@PathParam("cep") String cep) {
        Object raw = viaCEPService.getLocationByCEP(cep);
        Address address = addressRepository.pull(raw);

        return Response.ok(address).build();
    }
}
