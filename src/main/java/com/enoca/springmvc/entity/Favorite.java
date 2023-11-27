package com.enoca.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name="favorite")
public class Favorite {
    public Favorite(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;
    @Column(name="name")
    private  String name;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Customer customer;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Fav_Product",
            joinColumns = { @JoinColumn(name = "fav_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    @LazyCollection(LazyCollectionOption.FALSE)

    private Set<Product> products = new HashSet<>();


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
