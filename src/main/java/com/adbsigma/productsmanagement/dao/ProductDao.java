package com.adbsigma.productsmanagement.dao;

import com.adbsigma.productsmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
}