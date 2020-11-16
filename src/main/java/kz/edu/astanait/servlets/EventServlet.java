package kz.edu.astanait.servlets;

import kz.edu.astanait.controllers.EventController;
import kz.edu.astanait.models.Club;
import kz.edu.astanait.models.Event;
import kz.edu.astanait.rest.clients.EventClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "EventServlet", urlPatterns = "/eventservlet")
public class EventServlet extends HttpServlet {
    EventClient eventClient = new EventClient();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        Event obj;
        String btn = request.getParameter("btn");

        if(!btn.equals("Delete")){
            String author = request.getParameter("author");
            String date = request.getParameter("date");
            String name = request.getParameter("name");
            String image = request.getParameter("image");
            String description = request.getParameter("desc");

            obj =  new Event(name, image, description, author,date);

            switch (btn)
            {
                case "Add":
                    eventClient.add(obj);
                    doGet(request,response);
                    break;
                case "Update":
                    id = Integer.parseInt(request.getParameter("id"));
                    obj.setId(id);
                    eventClient.update(obj);
                    doGet(request,response);
                    break;
            }
        }else{
            id = Integer.parseInt(request.getParameter("id"));
            eventClient.delete(id);
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("jsp/confirmation.jsp");
    }
}
