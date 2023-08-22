package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Idea;

public interface IdeaRepository extends CrudRepository<Idea, Long> {
    List<Idea> findAll();

}
