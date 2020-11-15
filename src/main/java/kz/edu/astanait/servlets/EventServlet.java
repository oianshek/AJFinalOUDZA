package kz.edu.astanait.servlets;

import kz.edu.astanait.controllers.EventController;
import kz.edu.astanait.models.Event;

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
    private EventController cl = new EventController();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String btn = request.getParameter("btn");
        String author = "";

        if(request.getParameter("author").isEmpty())
        {
            Cookie[] cookies = request.getCookies();
            for(int i = 0; i < cookies.length; i++)
            {
                if(cookies[i].getName().equals("user"))
                {
                    author = cookies[i].getValue();
                }
            }
        }
        else
        {
            author = request.getParameter("author");
        }

        Date date;
        if(request.getParameter("date").isEmpty())
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date d = new java.util.Date();
            date = Date.valueOf(formatter.format(d));
            //System.out.println(formatter.format(date));
        }
        else
        {
            date = Date.valueOf(request.getParameter("date"));
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("desc");
        String strDate = String.valueOf(date);

        Event obj = new Event(id, name, image, description, author, strDate);

        switch (btn)
        {
            case "add":
                cl.add(obj);
                request.setAttribute("msg", "New Event added successfully.");
                break;

            case "update":
                cl.update(obj);
                request.setAttribute("msg", "Event updated successfully.");
                break;

            case "delete":
                cl.delete(obj.getId());
                request.setAttribute("msg", "Event deleted successfully.");
                break;
        }

        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Event> list = cl.getAll();

        request.setAttribute("events", list);

        request.getRequestDispatcher("/jsp/events.jsp").forward(request, response);
    }
}
