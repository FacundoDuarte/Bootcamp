package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.State;

public interface StateRepository extends CrudRepository<State, Long> {
    List<State> findAll();
}
