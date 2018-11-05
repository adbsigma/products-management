package com.adbsigma.productsmanagement.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private int prix;
    @ElementCollection
    private Set<Integer> categoriesId = new HashSet();

    public Product() {
    }

    public Product(int id, String nom, int prix, Set<Integer> categoriesId) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categoriesId = categoriesId;
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Set<Integer> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Set<Integer> categoriesId) {
        this.categoriesId = categoriesId;
    }
}