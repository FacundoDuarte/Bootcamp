package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
