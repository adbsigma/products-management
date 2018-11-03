package com.adbsigma.productsmanagement.web.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping(value="/Produits")
    public String listeProduits() {
        return "Un exemple de produit";
    }

    @GetMapping(value = "/Produits/{id}")
    public String afficherUnProduit(@PathVariable int id) {
        return "Vous avez demandé un produit avec l'id  " + id;
    }
}