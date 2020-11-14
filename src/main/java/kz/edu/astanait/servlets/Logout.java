package kz.edu.astanait.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Logout", urlPatterns = "/logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        Cookie[] cookies = request.getCookies();
        for(int a = 0; a < cookies.length; a++)
        {
            cookies[a].setValue("");
            cookies[a].setMaxAge(0);
            response.addCookie(cookies[a]);
        }

        response.sendRedirect(getServletContext().getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
