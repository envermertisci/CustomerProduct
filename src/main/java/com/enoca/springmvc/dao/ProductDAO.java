package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts();
    void deleteProduct(Integer id);
    void saveProduct(Product theProduct);
    Product getProduct(Integer id);
}
