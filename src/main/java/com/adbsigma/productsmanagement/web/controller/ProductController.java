package com.adbsigma.productsmanagement.web.controller;
import com.adbsigma.productsmanagement.dao.ProductDao;
import com.adbsigma.productsmanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @GetMapping(value="/Produits")
    public List<Product> listeProduits() {
        return productDao.findAll();

    }

    //Récupérer un produit par son Id
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }
}