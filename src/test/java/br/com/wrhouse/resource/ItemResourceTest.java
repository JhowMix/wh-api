package br.com.wrhouse.resource;

import br.com.wrhouse.model.Item;
import br.com.wrhouse.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status;

@QuarkusTest
@TestHTTPEndpoint(ItemResource.class)
public class ItemResourceTest {

    @Inject
    ItemRepository itemRepository;

    @Test
    public void createItem() {
        Item item = new Item();
        String itemJSON = "";

        item.setDetails("Item 01");
        item.setDetails("Item destinado a testes");

         try {
             ObjectMapper objectMapper = new ObjectMapper();
             itemJSON = objectMapper.writeValueAsString(item);
         } catch (Exception e) {
             e.printStackTrace();
         }

         given().contentType(ContentType.JSON)
                 .body(itemJSON)
                 .when().post()
                 .then()
                 .statusCode(Status.CREATED.getStatusCode());
    }

    @Test
    public void listAll() {
        Item[] itens =
                given()
                .when()
                .get()
                .then()
                .statusCode(200).extract()
                .as(Item[].class);

        Arrays.asList(itens).forEach(System.out::println);
    }

    @Test
    public void update() {
        Item item = itemRepository.find("id", 1l).firstResult();
        String itemJSON = "";

        item.setDetails("Teste de Update 01");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            itemJSON = objectMapper.writeValueAsString(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        given().contentType(ContentType.JSON)
                .body(itemJSON)
                .when()
                .put()
                .then()
                .statusCode(Status.ACCEPTED.getStatusCode());
    }
}
