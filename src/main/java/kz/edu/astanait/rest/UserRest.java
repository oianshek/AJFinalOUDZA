package kz.edu.astanait.rest;

import kz.edu.astanait.models.User;
import kz.edu.astanait.controllers.UserController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/users")
public class UserRest {
    private final UserController userController = new UserController();

    @GET
    public String index(){
        return "Welcome to User list";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{param}")
    public Response getByID(@PathParam("param") int userId) {
        User u;
        try {
            u = userController.getById(userId);
        } catch (ServerErrorException ex) {
            return Response.serverError().build();
        } catch (BadRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (u == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(u).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAll() {
        ArrayList<User> u;
        try {
            u = (ArrayList<User>) userController.getAll();
        } catch (ServerErrorException ex) {
            return Response.serverError().build();
        } catch (BadRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (u == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(u).build();
        }
    }
}
