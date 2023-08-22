package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();

    @Query(value = "SELECT * FROM tasks where project_id = ?1", nativeQuery = true)
    List<Task> findByTaskByProjectId(Long Id);
}
