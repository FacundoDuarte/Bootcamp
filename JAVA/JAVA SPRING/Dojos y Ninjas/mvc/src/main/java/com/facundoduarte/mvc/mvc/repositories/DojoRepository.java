package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();

    List<Dojo> findById(Integer id);

}
