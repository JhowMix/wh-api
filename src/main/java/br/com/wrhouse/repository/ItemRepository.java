package br.com.wrhouse.repository;

import br.com.wrhouse.model.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {

    @Transactional
    public void updateWithSync(final Item item) {
        final Item target = find("id", item.getId()).firstResult();

        target.setName(item.getName());
        target.setDetails(item.getDetails());

        item.getImages()
                .forEach(image -> {
                    if(!target.getImages().stream()
                            .filter(targetImage -> image.getId().equals(image.getId()))
                            .findAny()
                            .isPresent())
                        target.getImages().add(image);
                });

        item.getSuppliers()
                .forEach(supplier -> {
                    if(!target.getImages().stream()
                            .filter(targetImage -> supplier.getId().equals(supplier.getId()))
                            .findAny()
                            .isPresent())
                        target.getSuppliers().add(supplier);
                });

        persist(target);
    }
}
