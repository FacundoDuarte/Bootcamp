package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.LanguageModel;

public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {
    List<LanguageModel> findAll();

}
