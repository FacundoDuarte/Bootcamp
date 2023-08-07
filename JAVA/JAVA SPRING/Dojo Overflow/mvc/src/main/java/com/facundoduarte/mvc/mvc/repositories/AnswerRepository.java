package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAll();

}
