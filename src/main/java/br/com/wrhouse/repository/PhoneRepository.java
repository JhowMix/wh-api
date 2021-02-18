package br.com.wrhouse.repository;

import br.com.wrhouse.model.Phone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PhoneRepository implements PanacheRepository<Phone> {
}
