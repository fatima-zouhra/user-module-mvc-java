package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserDatabase;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    
    // Handles GET requests - serves the login page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); 
        if (session != null && session.getAttribute("user") != null) {  
            response.sendRedirect(request.getContextPath() + "/profile.jsp");  
            return;
        }
       
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
  
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            UserDatabase userDB = new UserDatabase(); 
            User user = userDB.getUser(email);  
           
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession(); 
                session.setAttribute("user", user); 
                response.sendRedirect(request.getContextPath() + "/profile.jsp");  
            } else {
                request.setAttribute("error", "Invalid email or password");  
                response.sendRedirect(request.getContextPath() + "/error.jsp"); 
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Database error occurred");
            response.sendRedirect(request.getContextPath() + "/error.jsp"); 
        }
    }
}
