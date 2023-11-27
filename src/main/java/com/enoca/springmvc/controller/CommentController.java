package com.enoca.springmvc.controller;

import com.enoca.springmvc.entity.Comment;
import com.enoca.springmvc.entity.Product;
import com.enoca.springmvc.service.CommentService;
import com.enoca.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public List<Comment> listComments(){
        List<Comment> comments = commentService.getComments();
        return comments ;
    }

    @PostMapping("/create/{productId}")
    public Comment createComment(@PathVariable(name = "productId") Integer productId,@RequestBody Comment com){
        Product product = productService.getProduct(productId);
        com.setProduct(product);
        commentService.saveComment(com);
        return com;
    }

    @DeleteMapping("/remove/{productId}/{id}")
    public List<Product> removeFromCom(@PathVariable(name = "productId") Integer productId,@PathVariable(name = "id") Integer id){
        Product productlist = productService.getProduct(productId);
        Comment comment = commentService.getComment(id);
        productlist.getComments().removeIf(comment1 -> comment1.getId() == comment.getId());
        productService.saveProduct(productlist);
        return productService.getProducts();
    }
}
