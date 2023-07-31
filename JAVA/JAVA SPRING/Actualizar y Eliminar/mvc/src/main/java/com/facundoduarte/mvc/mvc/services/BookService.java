package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.facundoduarte.mvc.mvc.models.BookModel;

import com.facundoduarte.mvc.mvc.repositories.BookRepository;

@Service
public class BookService {
    // Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Devolviendo todos los libros.
    public List<BookModel> allBooks() {
        return bookRepository.findAll();
    }

    // Creando un libro.
    public BookModel createBook(BookModel b) {
        return bookRepository.save(b);
    }

    // Obteniendo la información de un libro
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public BookModel updateBook(BookModel b) {
        Optional<BookModel> optionalBook = bookRepository.findById(b.getId());
        if (optionalBook.isPresent()) {
            b.setTitle(b.getTitle());
            b.setDescription(b.getDescription());
            b.setLanguage(b.getLanguage());
            b.setNumberOfPages(b.getNumberOfPages());
            bookRepository.save(b);
            return b;
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
