package com.facundoduarte.mvc.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoduarte.mvc.mvc.models.LanguageModel;
import com.facundoduarte.mvc.mvc.services.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/languages";
    }

    @GetMapping("/languages")
    public String index(Model model, @ModelAttribute("language") LanguageModel languageModel) {
        List<LanguageModel> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "index";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") LanguageModel languageModel, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        } else {
            languageService.createLanguage(languageModel);
            return "redirect:/languages";
        }
    }

    @GetMapping("/languages/{id}")
    public String show(Model model, @ModelAttribute("language") LanguageModel languageModel) {
        LanguageModel languages = languageService.findLanguageModel(languageModel.getId());
        model.addAttribute("language", languages);
        return "show";
    }

    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        LanguageModel language = languageService.findLanguageModel(id);
        model.addAttribute("language", language);
        return "edit";
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLangauge(id);
        return "redirect:/languages";
    }
}
