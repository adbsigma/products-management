package com.adbsigma.productsmanagement.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    @ElementCollection
    private Set<Integer> productsId = new HashSet();

    public Category() {
    }

    public Category(int id, String nom, Set<Integer> productsId) {
        this.id = id;
        this.nom = nom;
        this.productsId = productsId;
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

    public Set<Integer> getProductsId() {
        return productsId;
    }

    public void setProductsId(Set<Integer> productsId) {
        this.productsId = productsId;
    }
}
