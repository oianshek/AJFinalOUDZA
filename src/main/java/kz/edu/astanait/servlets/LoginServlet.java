package kz.edu.astanait.servlets;

import com.google.gson.Gson;
import kz.edu.astanait.controllers.UserController;
import kz.edu.astanait.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static UserController userController = new UserController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("check"))
        {
            HashMap<String, String> list = new HashMap<>();
            list.put("message", "empty");
            String email = request.getParameter("em");
            String pass = request.getParameter("p");
            email = email.toLowerCase();

            if(!email.isEmpty() && !pass.isEmpty()) {
                try {
                    User u = userController.check(email, pass);
                    if (u == null) {
                        list.put("message", "Wrong email or password!!!");
                    }
                    else
                    {
                        list.put("message", "success");

                        Cookie userName = new Cookie("user", u.getFirstName());
                        userName.setMaxAge(60*5*60);
                        response.addCookie(userName);

                        HttpSession sessions = request.getSession();
                        sessions.setAttribute("user", u);
                    }
                } catch (SQLException throwables) {
                    list.put("message", "Sql error");
                    throwables.printStackTrace();
                }
            }
            String json = new Gson().toJson(list);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
