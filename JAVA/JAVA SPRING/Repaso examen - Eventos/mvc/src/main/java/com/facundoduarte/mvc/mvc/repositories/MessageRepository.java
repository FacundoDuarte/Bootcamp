package com.facundoduarte.mvc.mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
