package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();

    @Query(value = "SELECT events.*\n" + //
            "FROM events\n" + //
            "JOIN users ON users.id = ?1\n" + //
            "JOIN states ON states.id = users.state_id\n" + //
            "WHERE events.state_id = users.state_id", nativeQuery = true)
    List<Event> findByUserState(Long userId);
}
