package br.com.wrhouse.resource;

import br.com.wrhouse.model.Supplier;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(SupplierResource.class)
public class SupplierResourceTest {
    
    @Test
    public void testGetSuppliers() {
        Supplier[] suppliers =
                given()
                        .when().get()
                        .then()
                        .statusCode(200).extract()
                        .as(Supplier[].class);
    }
}
