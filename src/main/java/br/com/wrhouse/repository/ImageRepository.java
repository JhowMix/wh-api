package br.com.wrhouse.repository;

import br.com.wrhouse.model.Image;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImageRepository implements PanacheRepository<Image> {
}
