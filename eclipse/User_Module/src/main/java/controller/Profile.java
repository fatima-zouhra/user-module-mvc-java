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

@WebServlet("/profile")
public class Profile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        try {
            User user = (User) session.getAttribute("user");
            user.setCountry(request.getParameter("country"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setJobTitle(request.getParameter("jobTitle"));
            user.setWorkPhone(request.getParameter("workPhone"));
            user.setCompanyName(request.getParameter("companyName"));
            user.setAddress(request.getParameter("address"));
            user.setCity(request.getParameter("city"));
            user.setZip(request.getParameter("zip"));

            UserDatabase userDB = new UserDatabase();
            userDB.updateUser(user);
            session.setAttribute("user", user);
            session.setAttribute("message", "Profile updated successfully");
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (SQLException e) {
            request.setAttribute("error", "Error updating profile");
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }
    }
}
