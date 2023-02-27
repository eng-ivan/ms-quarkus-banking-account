package core.ics;

import core.ics.repository.AccountRepository;
import core.ics.service.AccountService;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(InitializerTestContainers.class)
public class AccountResourceTest {

    @Test
    void listAccount() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/api/account/list")
                .then()
                .statusCode(OK.getStatusCode());
    }

    @Test
    void findAccountByID() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/account/{id}")
                .then()
                .statusCode(OK.getStatusCode());
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

}