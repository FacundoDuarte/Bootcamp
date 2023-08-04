package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Category;
import com.facundoduarte.mvc.mvc.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Category> findAllByProductsNotContaining(Product product);

}
