package kz.edu.astanait.servlets;

import kz.edu.astanait.controllers.NewsController;
import kz.edu.astanait.models.Club;
import kz.edu.astanait.models.Event;
import kz.edu.astanait.models.News;
import kz.edu.astanait.rest.clients.EventClient;
import kz.edu.astanait.rest.clients.NewsClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "NewsServlet", urlPatterns = "/newservlet")
public class NewsServlet extends HttpServlet {
    NewsClient newsClient = new NewsClient();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id;
        News obj;
        String btn = request.getParameter("btn");

        if(!btn.equals("Delete")){
            String author = request.getParameter("author");
            String date = request.getParameter("date");
            String name = request.getParameter("name");
            String image = request.getParameter("image");
            String description = request.getParameter("desc");

            obj =  new News(name, image, description, author,date);

            switch (btn)
            {
                case "Add":
                    newsClient.add(obj);
                    doGet(request,response);
                    break;
                case "Update":
                    id = Integer.parseInt(request.getParameter("id"));
                    obj.setId(id);
                    newsClient.update(obj);
                    doGet(request,response);
                    break;
            }
        }else{
            id = Integer.parseInt(request.getParameter("id"));
            newsClient.delete(id);
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("jsp/confirmation.jsp");
    }
}
