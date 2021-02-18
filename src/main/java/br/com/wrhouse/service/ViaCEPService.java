package br.com.wrhouse.service;

import netscape.javascript.JSObject;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ws")
@RegisterRestClient
public interface ViaCEPService {

    @GET
    @Path("{cep}/json")
    Object getLocationByCEP(@PathParam String cep);
}
