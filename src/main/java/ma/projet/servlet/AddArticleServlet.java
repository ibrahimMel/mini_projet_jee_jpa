package ma.projet.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.projet.model.Article;
import ma.projet.service.ArticleService;
import ma.projet.service.ArticleServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add-article")
public class AddArticleServlet extends HttpServlet {
    private ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String desc = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("quantite"));
        LocalDate exp = LocalDate.parse(request.getParameter("dateExpiration"));

        Article article = new Article(desc, price, qty, exp);
        articleService.addArticle(article);

        response.sendRedirect("articles");
    }
}
