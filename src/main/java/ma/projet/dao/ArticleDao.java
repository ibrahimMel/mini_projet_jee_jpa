package ma.projet.dao;

import ma.projet.model.Article;

import java.util.List;

public interface ArticleDao {
    void create(Article a);
    void update(Article a);
    void delete(Long id);
    Article getById(Long id);
    List<Article> getAll();
    List<Article> getAllSortedByPriceAsc();
    List<Article> getAllSortedByPriceDesc();
}
