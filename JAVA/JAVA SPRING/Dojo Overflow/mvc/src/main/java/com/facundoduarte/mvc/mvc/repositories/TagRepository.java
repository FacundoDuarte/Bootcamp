package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();

    Tag findBySubject(String subject);

}
