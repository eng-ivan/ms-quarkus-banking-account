package core.ics.controller;

import core.ics.service.AccountService;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@ApplicationScoped
@Path(value = "/api")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class AccountController {

    @Inject
    AccountService accountService;

    @POST
    @Path(value = "/account/save")
    @Transactional
    public Response save(){
        log.info("create account {}", accountService.save());
        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("/api/account/save"))
                .entity(accountService.save())
                .build();
    }

    @GET
    @Path(value = "/account/{id}")
    public Response findByID(@PathParam("id") String id){
        log.info("find account by ID {}", id);
        return Response
                .status(Response.Status.OK)
                .entity(accountService.findByID(id))
                .build();
    }

    @GET
    @Path(value = "/account/list")
    public Response list(){
        log.info("list accounts {}", accountService.list());
        return Response
                .status(Response.Status.OK)
                .entity(accountService.list())
                .build();
    }
}
