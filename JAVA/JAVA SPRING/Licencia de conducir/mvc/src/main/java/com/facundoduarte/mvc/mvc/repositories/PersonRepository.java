package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

}
