package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
     // If user is already logged in, redirect them to the profile page
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/profile.jsp");
            return;
        }
        
        if ("true".equals(request.getParameter("logout")) && session != null) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        
     // Pass any flash message (like "Profile updated") from session to request
        if (session != null) {
            String message = (String) session.getAttribute("message");
            if (message != null) {
                request.setAttribute("message", message);
                session.removeAttribute("message");
            }
        }
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
