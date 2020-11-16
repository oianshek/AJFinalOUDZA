package kz.edu.astanait.servlets;

import kz.edu.astanait.controllers.ClubController;
import kz.edu.astanait.models.Club;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ClubServlet", urlPatterns = "/clubservlet")
public class ClubServlet extends HttpServlet {
    private ClubController cl = new ClubController();

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
        Club obj = new Club(id, name, image, description, author,strDate);

        switch (btn)
        {
            case "add":
                cl.add(obj);
                request.setAttribute("msg", "New club added successfully.");
                break;

            case "update":
                cl.update(obj);
                request.setAttribute("msg", "Club updated successfully.");
                break;

            case "delete":
                cl.delete(obj.getId());
                request.setAttribute("msg", "Club deleted successfully.");
                break;
        }

        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Club> list = cl.getAll();

        request.setAttribute("clubs", list);

        request.getRequestDispatcher("/jsp/club.jsp").forward(request, response);


    }
}
