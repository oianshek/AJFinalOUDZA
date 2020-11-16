package kz.edu.astanait.rest;

import kz.edu.astanait.controllers.NewsController;
import kz.edu.astanait.models.Club;
import kz.edu.astanait.models.News;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/news")
public class NewsRest {

    private final NewsController newsController = new NewsController();

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<News> news;
        try {
            news = newsController.getAll();
        } catch (BadRequestException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok(news)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(News news) {
        try {
            newsController.add(news);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("New news added successfully.")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(News news) {
        try {
            newsController.update(news);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity(e.getMessage())
                    .build();
        }
        return Response
                .ok("News updated successfully.")
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try{
            newsController.delete(id);
        } catch (BadRequestException e) {
            return Response
                    .notModified()
                    .entity("News hasn't deleted.")
                    .build();
        }
        return Response
                .ok("News deleted successfully.")
                .build();
    }
}
