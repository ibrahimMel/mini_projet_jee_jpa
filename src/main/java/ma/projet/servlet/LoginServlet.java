package ma.projet.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.projet.service.UserService;
import ma.projet.service.UserServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("view/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean success = userService.authenticate(username, password);
		if (success) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("articles");
		} else {
			request.setAttribute("error", "Login ou mot de passe incorrect !");
			request.getRequestDispatcher("view/login.jsp").forward(request, response);
		}
	}
}
