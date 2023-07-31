package com.facundoduarte.mvc.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facundoduarte.mvc.mvc.models.BookModel;
import com.facundoduarte.mvc.mvc.services.BookService;

@RestController
public class BooksApi {
    private final BookService bookService;

    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public List<BookModel> index() {
        return bookService.allBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public BookModel create(@RequestParam(value = "title") String title,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
        BookModel book = new BookModel(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public BookModel show(@PathVariable("id") Long id) {
        BookModel book = bookService.findBook(id);
        return book;
    }

    // Otros métodos han sido removidos para resumir.
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public BookModel update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
            @RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
            @RequestParam(value = "pages") Integer numOfPages) {
        BookModel book = bookService.updateBook(bookService.findBook(id));
        if (book != null) {
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            bookService.createBook(book);
        }
        return book;
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
