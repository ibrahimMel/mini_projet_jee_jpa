package ma.projet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.projet.model.Article;
import ma.projet.service.ArticleService;
import ma.projet.service.ArticleServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet {

    private ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        String sort = request.getParameter("sort");
        List<Article> articles;

        if ("price_asc".equals(sort)) {
            articles = articleService.getAllSortedByPriceAsc();
        } else if ("price_desc".equals(sort)) {
            articles = articleService.getAllSortedByPriceDesc();
        } else {
            articles = articleService.getAll();
        }

        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/view/articles.jsp").forward(request, response);
    }
}
