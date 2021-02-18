package br.com.wrhouse.repository;

import br.com.wrhouse.model.Address;
import br.com.wrhouse.model.City;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.vertx.core.json.JsonObject;
import lombok.val;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {

    @Inject
    CityRepository cityRepository;

    public Address pull(Object raw) {
        val address = new Address();
        val json = JsonObject.mapFrom(raw);
        val ibgeCode = Long.valueOf(json.getString("ibge"));

        City city = cityRepository.getByIBGECode(ibgeCode);
        address.setCity(city);
        address.setPlaceDesc(json.getString("logradouro"));
        address.setDistrict(json.getString("bairro"));
        address.setZipCode(json.getString("cep").replace("-", ""));

        return address;
    }
}
