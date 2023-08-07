package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Question;
import com.facundoduarte.mvc.mvc.repositories.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public Question findQuestion(Long id) {
        return questionRepository.findById(id).get();
    }

    public List<Question> questionsAndTags(Long id) {
        return questionRepository.findQuestionsById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
}
