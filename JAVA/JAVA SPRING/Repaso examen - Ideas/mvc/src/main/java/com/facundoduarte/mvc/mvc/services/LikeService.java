package com.facundoduarte.mvc.mvc.services;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Idea;
import com.facundoduarte.mvc.mvc.models.Like;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.repositories.LikeRepository;

import jakarta.transaction.Transactional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional
    public void likeIdea(Idea idea, User user) {
        Like like = new Like(idea, user);
        likeRepository.save(like);
    }

    @Transactional
    public void dislikeIdea(Idea idea, User user) {
        likeRepository.deleteByIdeaAndUser(idea, user);
    }

    @Transactional
    public void deleteLikeByIdea(Long id) {
        likeRepository.deleteByIdeaId(id);
    }
}
