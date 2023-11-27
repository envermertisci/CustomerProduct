package com.enoca.springmvc.dao;


import com.enoca.springmvc.entity.Favorite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Qualifier("favoriteDao")
public class FavoriteDAOImpl implements FavoriteDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Favorite> getFavorites(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Favorite> cq = cb.createQuery(Favorite.class);
        Root<Favorite> root = cq.from(Favorite.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    @Override
    @Transactional
    public  void deleteFavorite(final Integer id){
        Session session = sessionFactory.getCurrentSession();
        Favorite book= session.byId(Favorite.class).load(id);
        session.delete(book);
    }
    @Override
    @Transactional
    public void saveFavorite(final Favorite favorite){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(favorite);
    }
    @Override
    @Transactional
    public Favorite getFavorite(final Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Favorite favorite = currentSession.get(Favorite.class, id);
        return favorite;
    }
}
