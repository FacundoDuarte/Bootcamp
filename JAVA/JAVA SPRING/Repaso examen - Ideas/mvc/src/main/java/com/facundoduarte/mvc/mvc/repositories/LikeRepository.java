package com.facundoduarte.mvc.mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Idea;
import com.facundoduarte.mvc.mvc.models.Like;
import com.facundoduarte.mvc.mvc.models.User;

public interface LikeRepository extends CrudRepository<Like, Long> {
    void deleteByIdeaAndUser(Idea idea, User user);

    void deleteByIdeaId(Long ideaId);
}
