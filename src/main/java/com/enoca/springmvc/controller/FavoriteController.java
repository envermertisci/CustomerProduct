package com.enoca.springmvc.controller;

import com.enoca.springmvc.entity.Customer;
import com.enoca.springmvc.entity.Favorite;
import com.enoca.springmvc.entity.Product;
import com.enoca.springmvc.service.CustomerService;
import com.enoca.springmvc.service.FavoriteService;
import com.enoca.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private CustomerService customerService;


    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Favorite> listFavorites(){
        List<Favorite> favorites = favoriteService.getFavorites();
        return favorites ;
    }
    @GetMapping("/get/{customerId}/favorite/{favId}")
    public Favorite getCusToFav(@PathVariable(name="customerId")Integer customerId,@PathVariable(name="favId") Integer favId){
        Customer customer = customerService.getCustomer(customerId);
        Favorite favoriteList = customer.getFavorites().stream().
                filter(favorite -> favorite.getId() == favId).findFirst().orElse(null);
        return favoriteList ;
    }

    @PostMapping("/create/{customerId}")
    public Favorite createFavorite(@PathVariable(name = "customerId") Integer customerId,@RequestBody Favorite fav){
        Customer customer = customerService.getCustomer(customerId);
        fav.setCustomer(customer);
        favoriteService.saveFavorite(fav);
        return fav;
    }

    @PostMapping("/add/{customerId}/{favId}")
    public Favorite addProductToFav(@PathVariable(name="customerId") Integer customerId, @PathVariable(name="favId") Integer favId,
                                         @RequestParam(name = "productId") Integer productId){
        Customer customer = customerService.getCustomer(customerId);

        Favorite favoriteList = customer.getFavorites().stream().
                filter(favorite -> favorite.getId() == favId).findFirst().orElse(null);
        Set<Product> products = favoriteList.getProducts();
        if(Objects.nonNull(favoriteList)){
          Product product =  productService.getProduct(productId);
          products.add(product);
          favoriteList.setProducts(products);
        }

        customerService.saveCustomer(customer);

        return favoriteList;

    }

    @PutMapping("/update/{id}")
    public Favorite updateCustomer(@PathVariable(name="id") Integer id, @RequestBody Favorite updatedFavorite){
        Favorite favorite = favoriteService.getFavorite(id);

        favoriteService.saveFavorite(favorite);
        return favorite;
    }
    @DeleteMapping("/remove/{id}/{productId}")
    public List<Favorite> removeFromFav(@PathVariable(name = "id") Integer id,@PathVariable(name = "productId") Integer productId){
        Favorite favoriteList = favoriteService.getFavorite(id);
        Product product = productService.getProduct(productId);
        favoriteList.getProducts().removeIf(product1 -> product1.getId() == product.getId());
        favoriteService.saveFavorite(favoriteList);
        return favoriteService.getFavorites();
    }
}
