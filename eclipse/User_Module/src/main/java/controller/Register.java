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

@WebServlet("/register")
public class Register extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");

        if (!password.equals(retypePassword)) {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if (password.length() < 4) {
            request.setAttribute("error", "Password must have 4+ chars");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        try {
            UserDatabase userDB = new UserDatabase();
            if (userDB.containsEmail(email)) {
                request.setAttribute("error", "Email already exists");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
                return;
            }

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setCountry(request.getParameter("country"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setJobTitle(request.getParameter("jobTitle"));
            user.setWorkPhone(request.getParameter("workPhone"));
            user.setCompanyName(request.getParameter("companyName"));
            user.setAddress(request.getParameter("address"));
            user.setCity(request.getParameter("city"));
            user.setZip(request.getParameter("zip"));

            userDB.addUser(user);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (SQLException e) {
            request.setAttribute("error", "Database error occurred" + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
