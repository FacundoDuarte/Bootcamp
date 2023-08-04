package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Category;
import com.facundoduarte.mvc.mvc.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findAllByCategoriesNotContaining(Category category);
}
