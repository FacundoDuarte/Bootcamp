package com.facundoduarte.authentication.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.authentication.authentication.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
