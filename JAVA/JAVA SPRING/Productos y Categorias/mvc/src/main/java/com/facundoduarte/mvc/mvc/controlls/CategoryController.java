package com.facundoduarte.mvc.mvc.controlls;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoduarte.mvc.mvc.models.Category;
import com.facundoduarte.mvc.mvc.models.Product;
import com.facundoduarte.mvc.mvc.services.CategoryService;
import com.facundoduarte.mvc.mvc.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category c) {
        return "newCategory";
    }

    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("category") Category c,
            BindingResult result) {
        if (result.hasErrors()) {
            return "newCategory";
        } else {
            categoryService.createCategory(c);
            return "redirect:/categories/new";
        }
    }

    @GetMapping("/categories/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findCategory(id);
        List<Product> productsNotInCategory = productService.allProductsIsNull(category);

        if (category != null) {
            model.addAttribute("category", category);
            model.addAttribute("products", productsNotInCategory);
            model.addAttribute("product", new Product());
            return "showCategory";
        } else {

            return "redirect:/categories";
        }
    }

    @PostMapping("/categories/{id}")
    public String addProductByCategory(@PathVariable Long id, @ModelAttribute("product") Product product) {
        Category category = categoryService.findCategory(id);
        Product selectedProduct = productService.findProduct(product.getId());

        if (category != null && selectedProduct != null) {
            category.getProducts().add(selectedProduct);
            categoryService.createCategory(category);
        }
        return "redirect:/categories/" + id;
    }

}
