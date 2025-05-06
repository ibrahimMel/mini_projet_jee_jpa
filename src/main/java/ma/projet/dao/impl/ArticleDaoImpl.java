package ma.projet.dao.impl;

import jakarta.persistence.EntityManager;
import ma.projet.dao.ArticleDao;
import ma.projet.model.Article;
import ma.projet.util.JpaUtil;

import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    @Override
    public void create(Article a) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    @Override
    public void update(Article a) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Article a = em.find(Article.class, id);
        if (a != null) em.remove(a);
        em.getTransaction().commit();
    }

    @Override
    public Article getById(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Article.class, id);
    }

    @Override
    public List<Article> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }

    @Override
    public List<Article> getAllSortedByPriceAsc() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT a FROM Article a ORDER BY a.price ASC", Article.class).getResultList();
    }

    @Override
    public List<Article> getAllSortedByPriceDesc() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT a FROM Article a ORDER BY a.price DESC", Article.class).getResultList();
    }
}
