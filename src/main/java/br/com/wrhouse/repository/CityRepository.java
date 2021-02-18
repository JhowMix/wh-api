package br.com.wrhouse.repository;

import br.com.wrhouse.model.City;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CityRepository implements PanacheRepository<City> {

    public List<City> getByUF(String ufCode) {
        return find("uf.code", ufCode).list();
    }

    public City getByIBGECode(Long ibgeCode) {
        return find("ibgeCode", ibgeCode).firstResult();
    }
}
