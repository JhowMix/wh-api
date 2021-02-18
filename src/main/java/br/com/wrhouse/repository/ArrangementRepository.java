package br.com.wrhouse.repository;

import br.com.wrhouse.model.Arrangement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArrangementRepository implements PanacheRepository<Arrangement> {

}
