package com.adbsigma.productsmanagement.dao;

import com.adbsigma.productsmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    public List<Category> findAll();
    public Category findById(int id);
    public Category save(Category category);
}
