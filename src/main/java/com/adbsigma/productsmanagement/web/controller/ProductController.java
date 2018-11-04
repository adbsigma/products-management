package com.adbsigma.productsmanagement.web.controller;
import com.adbsigma.productsmanagement.dao.ProductDao;
import com.adbsigma.productsmanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @GetMapping(value="/Produits")
    public List<Product> listeProduits() {
        Iterable<Product> produits = productDao.findAll();
        return (List<Product>) produits;
    }


    //Récupérer un produit par son Id
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    //Récupérer un produit par son ParentId
    @GetMapping(value="/Produits/Categorie/{parentId}")
    public List<Product> afficherUneCategorie(@PathVariable int parentId) {
        return productDao.findByParentId(parentId);
    }

    //ajouter un produit
    @PostMapping(value = "/Produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {

        Product productAdded =  productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (value = "/Produits/{id}")
    public void supprimerProduit(@PathVariable int id) {
        productDao.deleteById(id);
    }

    @PutMapping (value = "/Produits")
    public void updateProduit(@RequestBody Product product) {
        productDao.save(product);
    }
}