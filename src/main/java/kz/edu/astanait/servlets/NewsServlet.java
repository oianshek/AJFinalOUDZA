package kz.edu.astanait.servlets;

import kz.edu.astanait.controllers.NewsController;
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

        News obj = new News(id, name, image, description, author, strDate);

        switch (btn)
        {
            case "Add":
                newsClient.add(obj);
                request.setAttribute("msg", "New News added successfully.");
                break;

            case "Update":
                newsClient.update(obj);
                doGet(request,response);
                break;

            case "Delete":
                newsClient.delete(obj.getId());
                request.setAttribute("msg", "News deleted successfully.");
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("jsp/confirmation.jsp");
    }
}
