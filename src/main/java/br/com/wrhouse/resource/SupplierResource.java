package br.com.wrhouse.resource;

import br.com.wrhouse.model.Supplier;
import br.com.wrhouse.repository.SupplierRepository;
import lombok.extern.java.Log;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;

@Path("suppliers") @Log
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SupplierResource {

    @Inject
    SupplierRepository supplierRepository;

    @POST
    @Transactional
    public Response save(Supplier supplier) {
        supplier.setCreatedAt(LocalDateTime.now());
        supplierRepository.create(supplier);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response update(Supplier supplier) {
        supplierRepository.update(supplier);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    public List<Supplier> all() {
         return supplierRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Supplier one(@PathParam("id") Long id) {
         return supplierRepository.findById(id);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        this.supplierRepository.deleteById(id);
        return Response.noContent().build();
    }
}
