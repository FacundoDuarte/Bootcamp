package com.facundoduarte.mvc.mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
