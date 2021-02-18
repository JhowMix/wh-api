package br.com.wrhouse.repository;

import br.com.wrhouse.model.Code;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CodeRepository implements PanacheRepository<Code> {
}
