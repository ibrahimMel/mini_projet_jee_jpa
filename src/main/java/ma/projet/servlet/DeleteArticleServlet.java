package ma.projet.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.projet.service.ArticleService;
import ma.projet.service.ArticleServiceImpl;

import java.io.IOException;

@WebServlet("/delete-article")
public class DeleteArticleServlet extends HttpServlet {
	private ArticleService articleService = new ArticleServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		articleService.deleteArticle(id);
		response.sendRedirect("articles");
	}
}
