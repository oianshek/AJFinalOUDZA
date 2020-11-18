package kz.edu.astanait.rest;

import kz.edu.astanait.controllers.EventController;
import kz.edu.astanait.models.Event;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/event")
public class EventRest {
    private final EventController eventController = new EventController();

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Event> event;
        try {
            event = eventController.getAll();
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(event)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Event event) {
        try {
            eventController.add(event);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("New event added successfully.")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Event event) {
        try {
            eventController.update(event);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("Event updated successfully.")
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try{
            eventController.delete(id);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("Event hasn't deleted.")
                    .build();
        }
        return Response
                .ok("Event deleted successfully.")
                .build();
    }
}
