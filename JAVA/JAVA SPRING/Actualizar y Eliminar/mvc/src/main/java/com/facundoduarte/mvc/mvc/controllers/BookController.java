package com.facundoduarte.mvc.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoduarte.mvc.mvc.models.BookModel;
import com.facundoduarte.mvc.mvc.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String index(Model model) {
        List<BookModel> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") BookModel book) {
        return "newBook";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping("/books/{id}")
    public String show(@ModelAttribute("book") BookModel b, Model model) {
        BookModel book = bookService.findBook(b.getId());
        model.addAttribute("book", book);
        return "show";
    }

    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        BookModel book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
