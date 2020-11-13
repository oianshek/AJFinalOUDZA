package kz.edu.astanait.rest;

import kz.edu.astanait.models.Event;
import kz.edu.astanait.models.User;
import kz.edu.astanait.controllers.UserController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserRest {
    private static UserController userController = new UserController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<User> user;
        try {
            user = userController.getAll();
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(user)
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User user) {
        try {
            userController.update(user);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("User updated successfully.")
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try{
            userController.delete(id);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("User hasn't deleted.")
                    .build();
        }
        return Response
                .ok("User deleted successfully.")
                .build();
    }
}
