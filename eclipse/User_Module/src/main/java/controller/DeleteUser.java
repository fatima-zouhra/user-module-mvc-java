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

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect("home.jsp");
			return;
		}

		User user = (User) session.getAttribute("user");
		String email = user.getEmail();

		UserDatabase userDB = new UserDatabase();
		boolean success = userDB.deleteUserByEmail(email);

		// Create a new temporary session to carry the message after invalidation
		if (success) {
			session.invalidate(); // Ends the current session
			HttpSession newSession = request.getSession(true); // Create new session
			newSession.setAttribute("message", "Your account has been deleted.");
		} else {
			request.setAttribute("error", "Account deletion failed.");
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("home.jsp");
	}
}
