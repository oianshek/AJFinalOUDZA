package kz.edu.astanait.servlets;

import kz.edu.astanait.models.Event;
import kz.edu.astanait.models.News;
import kz.edu.astanait.rest.clients.EventClient;
import kz.edu.astanait.rest.clients.NewsClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "NewsServlet", urlPatterns = "/newservlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String btn = request.getParameter("btn");
        String author = "";

        NewsClient cl = new NewsClient();

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
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
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

        News obj = new News(id, name, image, description, author, date);

        switch (btn)
        {
            case "add":
                cl.add(obj);
                request.setAttribute("msg", "New News added successfully.");
                break;

            case "update":
                cl.update(obj);
                request.setAttribute("msg", "News updated successfully.");
                break;

            case "delete":
                cl.delete(obj.getId());
                request.setAttribute("msg", "News deleted successfully.");
                break;
        }

        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
