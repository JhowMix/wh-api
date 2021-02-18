package br.com.wrhouse.repository;

import br.com.wrhouse.model.City;
import br.com.wrhouse.model.Supplier;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class SupplierRepository implements PanacheRepository<Supplier> {

    @Inject
    CityRepository cityRepository;

    @Transactional
    public void update(Supplier supplier) {
        Supplier managed = findById(supplier.getId());
        persist(managed);
    }

    @Transactional
    public void create(Supplier supplier) {
        supplier.getAddresses().forEach(address -> {
            address.setCity(cityRepository.getByIBGECode(address.getCity().getIbgeCode()));
        });

        persist(supplier);
    }
}
