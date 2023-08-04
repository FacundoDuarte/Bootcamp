package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Category;
import com.facundoduarte.mvc.mvc.models.Product;
import com.facundoduarte.mvc.mvc.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    public List<Product> allProductsIsNull(Category c) {
        return productRepository.findAllByCategoriesNotContaining(c);
    }

    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }
}
