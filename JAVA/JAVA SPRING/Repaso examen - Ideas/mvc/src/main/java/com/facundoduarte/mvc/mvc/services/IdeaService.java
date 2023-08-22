package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Idea;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.repositories.IdeaRepository;

@Service
public class IdeaService {
    private final IdeaRepository ideaRepository;

    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public Idea createIdea(Idea idea) {
        return ideaRepository.save(idea);
    }

    public List<Idea> allIdeas() {
        return ideaRepository.findAll();
    }

    public Idea findIdea(Long id) {
        Optional<Idea> optionalIdea = ideaRepository.findById(id);
        if (optionalIdea.isPresent()) {
            return optionalIdea.get();
        } else {
            return null;
        }
    }

    public List<Idea> getAllIdeasWithLikesAndCurrentUser(User currentUser) {
        List<Idea> ideasWithLikes = ideaRepository.findAll();

        for (Idea idea : ideasWithLikes) {
            idea.setLikedByCurrentUser(idea.isLikedByUser(currentUser));
        }
        return ideasWithLikes;
    }

    public void deleteIdea(Long id) {
        ideaRepository.deleteById(id);
    }
}
