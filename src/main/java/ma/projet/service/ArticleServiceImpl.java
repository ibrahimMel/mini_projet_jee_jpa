package ma.projet.service;

import ma.projet.dao.ArticleDao;
import ma.projet.dao.impl.ArticleDaoImpl;
import ma.projet.model.Article;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao = new ArticleDaoImpl();

	@Override
	public void create(Article a) {
		articleDao.create(a);
	}

	@Override
	public void update(Article a) {
		articleDao.update(a);
	}

	@Override
	public void delete(Long id) {
		articleDao.delete(id);
	}

	@Override
	public Article getById(Long id) {
		return articleDao.getById(id);
	}

	@Override
	public List<Article> getAll() {
		return articleDao.getAll();
	}

	@Override
	public List<Article> getAllSortedByPriceAsc() {
		return articleDao.getAllSortedByPriceAsc();
	}

	@Override
	public List<Article> getAllSortedByPriceDesc() {
		return articleDao.getAllSortedByPriceDesc();
	}

	@Override
	public void addArticle(Article article) {
		articleDao.create(article);
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.update(article);
	}

	@Override
	public void deleteArticle(Long id) {
		articleDao.delete(id);
	}

}
