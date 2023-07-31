package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.LanguageModel;
import com.facundoduarte.mvc.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageModel> allLanguages() {
        return languageRepository.findAll();
    }

    public LanguageModel createLanguage(LanguageModel l) {
        return languageRepository.save(l);
    }

    public LanguageModel findLanguageModel(Long id) {
        Optional<LanguageModel> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    public LanguageModel updateLanguage(LanguageModel l) {
        Optional<LanguageModel> optionalLanguage = languageRepository.findById(l.getId());
        if (optionalLanguage.isPresent()) {
            LanguageModel languageUpdated = languageRepository.save(l);
            return languageUpdated;
        } else {
            return null;
        }
    }

    public void deleteLangauge(Long id) {
        languageRepository.deleteById(id);
    }
}
