package kz.edu.astanait.rest;

import kz.edu.astanait.controllers.ClubController;
import kz.edu.astanait.models.Club;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/club")
public class ClubRest {
    private final ClubController clubController = new ClubController();

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Club> clubs;
        try {
            clubs = clubController.getAll();
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(clubs)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Club club) {
        try {
            clubController.add(club);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("New club added successfully.")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Club club) {
        try {
            clubController.update(club);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("Club updated successfully.")
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try{
            clubController.delete(id);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("Club hasn't deleted.")
                    .build();
        }
        return Response
                .ok("Club deleted successfully.")
                .build();
    }
}
