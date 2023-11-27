package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Customer;
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

@Repository
@Qualifier
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Product> getProducts(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
    @Override
    @Transactional
    public  void deleteProduct(final Integer id){
        Session session = sessionFactory.getCurrentSession();
        Product book= session.byId(Product.class).load(id);
        session.delete(book);
    }
    @Override
    @Transactional
    public void saveProduct(final Product theProduct){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theProduct);
}
    @Override
    @Transactional
    public Product getProduct(final Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product theProduct = currentSession.get(Product.class, id);
        return theProduct;
    }

}
