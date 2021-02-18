package br.com.wrhouse.repository;

import br.com.wrhouse.model.UF;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UFRepository implements PanacheRepository<UF> {

    @Transactional
    public UF findByCode(String code) {
        return find("code", code).firstResult();
    }
}
