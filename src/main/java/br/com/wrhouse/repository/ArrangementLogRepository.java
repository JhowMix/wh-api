package br.com.wrhouse.repository;

import br.com.wrhouse.model.ArrangementLog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArrangementLogRepository implements PanacheRepository<ArrangementLog> {

}
