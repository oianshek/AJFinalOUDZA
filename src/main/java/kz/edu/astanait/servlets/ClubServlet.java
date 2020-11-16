package kz.edu.astanait.servlets;

import kz.edu.astanait.controllers.ClubController;
import kz.edu.astanait.models.Club;
import kz.edu.astanait.rest.clients.ClubClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ClubServlet", urlPatterns = "/clubservlet")
public class ClubServlet extends HttpServlet {
    ClubClient clubClient = new ClubClient();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        Club obj;
        String btn = request.getParameter("btn");

        if(!btn.equals("Delete")){
            String author = request.getParameter("author");
            String date = request.getParameter("date");
            String name = request.getParameter("name");
            String image = request.getParameter("image");
            String description = request.getParameter("desc");

            obj =  new Club(name, image, description, author,date);

            switch (btn)
            {
                case "Add":
                    clubClient.add(obj);
                    doGet(request,response);
                    break;
                case "Update":
                    id = Integer.parseInt(request.getParameter("id"));
                    obj.setId(id);
                    clubClient.update(obj);
                    doGet(request,response);
                    break;
            }
        }else{
                id = Integer.parseInt(request.getParameter("id"));
                clubClient.delete(id);
                doGet(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("jsp/confirmation.jsp");
    }
}
