package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.BookModel;

public interface BookRepository extends CrudRepository<BookModel, Long> {
    // Este método recupera todos los libros de la base de datos
    List<BookModel> findAll();

    // Este método encuentra un libro por su descripción
    List<BookModel> findByDescriptionContaining(String search);

    List<BookModel> findById(Integer id);

    // Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTitleContaining(String search);

    // Este método borra un libro que empieza con un título específico
    Long deleteByTitleStartingWith(String search);
}
