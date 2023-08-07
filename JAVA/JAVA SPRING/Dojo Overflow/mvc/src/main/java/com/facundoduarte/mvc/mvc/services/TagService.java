package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Tag;
import com.facundoduarte.mvc.mvc.repositories.TagRepository;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> allTags() {
        return tagRepository.findAll();
    }

    public Tag getTagBySubject(String subject) {
        return tagRepository.findBySubject(subject);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
}
