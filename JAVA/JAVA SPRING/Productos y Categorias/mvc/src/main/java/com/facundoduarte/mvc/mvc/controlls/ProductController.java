package com.facundoduarte.mvc.mvc.controlls;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.facundoduarte.mvc.mvc.models.Category;
import com.facundoduarte.mvc.mvc.models.Product;
import com.facundoduarte.mvc.mvc.services.CategoryService;
import com.facundoduarte.mvc.mvc.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product p) {
        return "newProduct";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product p,
            BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct";
        } else {
            productService.createProduct(p);
            return "redirect:/products/new";
        }
    }

    @GetMapping(value = "/products/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Product product = productService.findProduct(id);
        List<Category> categoriesNotInProduct = categoryService.allCategoriesIsNull(product);

        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("categories", categoriesNotInProduct);
            model.addAttribute("category", new Category());
            return "showProduct";
        } else {
            return "redirect:/products/";
        }
    }

    @PostMapping(value = "/products/{id}")
    public String addCategoryByProducString(@PathVariable Long id, @ModelAttribute("category") Category category) {
        Product product = productService.findProduct(id);
        Category selectedCategory = categoryService.findCategory(category.getId());

        if (category != null && selectedCategory != null) {
            product.getCategories().add(selectedCategory);
            productService.createProduct(product);
        }
        return "redirect:/products/" + id;
    }

}
