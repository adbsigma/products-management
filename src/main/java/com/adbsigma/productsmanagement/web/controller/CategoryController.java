package com.adbsigma.productsmanagement.web.controller;
import com.adbsigma.productsmanagement.dao.CategoryDao;
import com.adbsigma.productsmanagement.dao.ProductDao;
import com.adbsigma.productsmanagement.model.Category;
import com.adbsigma.productsmanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {


    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des categories
    @GetMapping(value="/Categories")
    public List<Category> listeCategories() {
        Iterable<Category> categories = categoryDao.findAll();
        return (List<Category>) categories;
    }


    //Récupérer une categorie par son Id
    @GetMapping(value="/Categories/{id}")
    public Category afficherUneCategorie(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    //ajouter une categorie
    @PostMapping(value = "/Categories")
    public ResponseEntity<Void> ajouterCategorie(@RequestBody Category category) {

        Category categoryAdded =  categoryDao.save(category);

        if (categoryAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoryAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (value = "/Categories/{id}")
    public void supprimerCategorie(@PathVariable int id) {
        categoryDao.deleteById(id);
    }

    @PutMapping (value = "/Categories")
    public void updateCategorie(@RequestBody Category category) {
        categoryDao.save(category);
    }

    @PostMapping (value = "/Categories/{categoryId}")
    public ResponseEntity<Object> addProductToCategory(@PathVariable int categoryId, @RequestBody Product product)
    {
        Product productAdded =  productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        Category category = categoryDao.findById(categoryId);
        if(category == null)
            return ResponseEntity.noContent().build();
        category.addProduct(productAdded);
        categoryDao.save(category);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping (value = "/Categories/{id}/Produits")
    public Set<Product> findCategoryProductsById(@PathVariable int id)
    {
        return categoryDao.findById(id).getProducts();
    }
}