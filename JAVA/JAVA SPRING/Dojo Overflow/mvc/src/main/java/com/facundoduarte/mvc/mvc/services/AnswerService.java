package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Answer;
import com.facundoduarte.mvc.mvc.repositories.AnswerRepository;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

    public Answer findAnswer(Long id) {
        return answerRepository.findById(id).get();

    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
}
