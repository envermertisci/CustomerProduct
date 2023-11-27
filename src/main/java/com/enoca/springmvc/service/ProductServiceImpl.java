package com.enoca.springmvc.service;

import com.enoca.springmvc.dao.ProductDAO;
import com.enoca.springmvc.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> getProducts(){return productDAO.getProducts();}
    @Override
    public void saveProduct(final Product theProduct){
        productDAO.saveProduct(theProduct);
    }
    @Override
    public Product getProduct(final Integer id){return productDAO.getProduct(id);}
    @Override
    public void deleteProduct(final Integer id){productDAO.deleteProduct(id);}
}
