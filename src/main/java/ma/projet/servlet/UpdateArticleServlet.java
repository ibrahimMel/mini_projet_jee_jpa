package ma.projet.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.projet.model.Article;
import ma.projet.service.ArticleService;
import ma.projet.service.ArticleServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/update-article")
public class UpdateArticleServlet extends HttpServlet {
    private ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String desc = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("quantite"));
        LocalDate exp = LocalDate.parse(request.getParameter("dateExpiration"));

        Article article = new Article(desc, price, qty, exp);
        article.setId(id);
        articleService.updateArticle(article);

        response.sendRedirect("articles");
    }
}
