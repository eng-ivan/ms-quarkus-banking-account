package core.ics.controller;

import core.ics.service.AccountService;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@ApplicationScoped
@Path(value = "/api")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class AccountController {

    @Inject
    AccountService accountService;

    @GET
    @Path(value = "/account/list")
    public Response list(){

        return Response
                .status(Response.Status.OK)
                .entity(accountService.list())
                .build();
    }
}
