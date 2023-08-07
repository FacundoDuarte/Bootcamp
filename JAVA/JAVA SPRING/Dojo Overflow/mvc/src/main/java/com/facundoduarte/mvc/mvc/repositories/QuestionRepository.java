package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.facundoduarte.mvc.mvc.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();

    @Query("SELECT DISTINCT q FROM Question q LEFT JOIN FETCH q.tags WHERE q.question LIKE %:id%")
    List<Question> findQuestionsById(@Param("id") Long id);

}
