package core.ics;

import core.ics.repository.AccountRepository;
import core.ics.service.AccountService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AccountResourceTest {

    @Inject
    AccountRepository accountRepository;
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
                .statusCode(OK.getStatusCode())
                .body("agency", is(accountRepository.findById(1L).getAgency()))
                .body("account", is(accountRepository.findById(1L).getAccount()));
    }

}