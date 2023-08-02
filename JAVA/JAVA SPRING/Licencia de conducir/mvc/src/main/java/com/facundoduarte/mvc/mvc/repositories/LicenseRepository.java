package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();

    License findByPersonId(Long id);
}
