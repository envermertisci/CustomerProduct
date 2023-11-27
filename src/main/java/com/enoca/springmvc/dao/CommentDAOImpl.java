package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Comment;
import com.enoca.springmvc.entity.Product;
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
import java.util.Set;

@Repository
@Qualifier("commentDao")
public class CommentDAOImpl implements CommentDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Comment> getComments(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
        Root<Comment> root = cq.from(Comment.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    @Override
    @Transactional
    public  void deleteComment(final Integer id){
        Session session = sessionFactory.getCurrentSession();
        Comment book= session.byId(Comment.class).load(id);
        session.delete(book);
    }
    @Override
    @Transactional
    public void saveComment(final Comment comment){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(comment);
    }
    @Override
    @Transactional
    public Comment getComment(final Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Comment comment = currentSession.get(Comment.class, id);
        return comment;
    }
    @Override
    public Set<Comment> getCommentsByProduct(final Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product product = currentSession.get(Product.class, id);
        return (Set<Comment>) product.getComments();
    }
}
