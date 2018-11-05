package com.adbsigma.productsmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Product> products;

    public Category() {
    }

    public Category(int id, String nom, Category parent, Set<Category> children, Set<Product> products) {
        this.id = id;
        this.nom = nom;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product)
    {
        if(this==null)
            System.out.println("ok");
        if(product==null)
            System.out.println("ok");
        product.addToCategory(this);
        products.add(product);
    }
}
