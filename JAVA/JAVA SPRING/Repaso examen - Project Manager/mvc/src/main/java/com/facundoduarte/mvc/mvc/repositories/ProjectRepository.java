package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.facundoduarte.mvc.mvc.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
        List<Project> findAll();

        @Query(value = "SELECT projects.* FROM projects \n" + //
                        "LEFT JOIN teammates\n" + //
                        "ON teammates.project_id = projects.id\n" + //
                        "WHERE projects.user_id = :userId OR teammates.user_id= :userId\n" + //
                        "GROUP BY projects.id", nativeQuery = true)
        List<Project> findByLeaderId(@Param("userId") Long userId);

        @Query(value = "SELECT projects.* FROM projects\n" +
                        "LEFT JOIN teammates ON teammates.project_id = projects.id AND teammates.user_id = :userId\n" +
                        "WHERE projects.user_id != :userId AND teammates.user_id IS NULL", nativeQuery = true)
        List<Project> findProjectsWhereNotLeader(@Param("userId") Long userId);

}
