package br.com.wrhouse.repository;

import br.com.wrhouse.model.MeasurementUnit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeasurementUnitRepository implements PanacheRepository<MeasurementUnit> {
}
