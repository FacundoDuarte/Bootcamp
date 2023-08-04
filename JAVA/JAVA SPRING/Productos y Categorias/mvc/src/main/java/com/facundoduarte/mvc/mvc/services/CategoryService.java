package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Category;
import com.facundoduarte.mvc.mvc.models.Product;
import com.facundoduarte.mvc.mvc.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    // public List<Category> allCategoriesIsNull(Product p) {
    // return categoryRepository.findAllByCategoriesNotContaining(p);
    // }
    public List<Category> allCategoriesIsNull(Product p) {
        return categoryRepository.findAllByProductsNotContaining(p);
    }

}
