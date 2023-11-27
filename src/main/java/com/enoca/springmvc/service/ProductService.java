package com.enoca.springmvc.service;

import com.enoca.springmvc.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    void saveProduct(Product theProduct);
    Product getProduct(Integer id);
    void deleteProduct(Integer id);
}
