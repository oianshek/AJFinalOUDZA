package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.controllers.UserController;
import kz.edu.astanait.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/userservlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("radio");
        UserController cl = new UserController();
        String json = null;

        if(action.equals("group")){
            List<User> groupList = cl.getByGroup(request.getParameter("obj"));
            json = new Gson().toJson(groupList);
        }else if(action.equals("course")){
            List<User> yearList = cl.getByCourse(Integer.parseInt(request.getParameter("obj")));
            json = new Gson().toJson(yearList);
        }else if(action.equals("major")){
            List<User> majorList = cl.getByMajor(request.getParameter("obj"));
            json = new Gson().toJson(majorList);
        }else if(action.equals("name")){
            List<User> nameList = cl.getByName(request.getParameter("obj"));
            json = new Gson().toJson(nameList);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
