package core.ics;


import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

@QuarkusTest
//@QuarkusTestResource(InitializerTestContainers.class)
public class AccountResourceTest {

    @Test
    void listAccount() {
        given()
                .when()
                .get("/api/account/list")
                .then()
                .statusCode(OK.getStatusCode());
    }

   @Test
    void findAccountByID() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", "1")
                .when()
                .get("/api/account/{id}")
                .then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    void notFoundByID() {
        given()
                .pathParam("id", "Q")
                .when()
                .get("/api/account/{id}")
                .then()
                .statusCode(NOT_FOUND.getStatusCode());
    }

    @Test
    void formatExceptionFindByID() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", "Q")
                .when()
                .get("/api/account/{id}")
                .then()
                .statusCode(NOT_FOUND.getStatusCode());
    }

    @Test
    void connectionTest() throws UnknownHostException {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/api/connection-test")
                .then()
                .statusCode(OK.getStatusCode());
    }

    //sudo ln -s $HOME/.docker/run/docker.sock /var/run/docker.sock
}