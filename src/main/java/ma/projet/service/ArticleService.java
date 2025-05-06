package ma.projet.service;

import ma.projet.model.Article;

import java.util.List;

public interface ArticleService {
	void create(Article a);

	void update(Article a);

	void delete(Long id);

	Article getById(Long id);

	List<Article> getAll();

	List<Article> getAllSortedByPriceAsc();

	List<Article> getAllSortedByPriceDesc();

	void addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(Long id);

}
