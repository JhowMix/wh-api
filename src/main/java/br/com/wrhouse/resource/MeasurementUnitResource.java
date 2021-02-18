package br.com.wrhouse.resource;

import br.com.wrhouse.model.Measurement;
import br.com.wrhouse.model.MeasurementUnit;
import br.com.wrhouse.repository.MeasurementUnitRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("measurement-units")
public class MeasurementUnitResource {

    @Inject
    MeasurementUnitRepository measurementUnitRepository;

    @GET
    public List<MeasurementUnit> all() {
        return measurementUnitRepository.listAll();
    }
}
