package com.enoca.springmvc.controller;



import com.enoca.springmvc.entity.Product;
import com.enoca.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public List<Product> listProducts(){
        List<Product> products = productService.getProducts();
        return products;
    }
    @PostMapping("/create")
    public List<Product> createProduct(@RequestBody Product pro){
        productService.saveProduct(pro);
        return productService.getProducts();
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable(name="id") Integer id, @RequestBody Product updatedProduct){
        Product product = productService.getProduct(id);
        product.setProductName(updatedProduct.getProductName());
        product.setProductName(updatedProduct.getProductName());
        productService.saveProduct(product);
        return product;

    }
    @DeleteMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable(name = "id")Integer id){
        productService.deleteProduct(id);
        return productService.getProducts();
    }
}

