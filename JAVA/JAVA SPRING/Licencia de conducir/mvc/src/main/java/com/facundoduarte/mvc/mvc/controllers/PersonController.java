package com.facundoduarte.mvc.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoduarte.mvc.mvc.models.License;
import com.facundoduarte.mvc.mvc.models.Person;
import com.facundoduarte.mvc.mvc.services.LicenseService;
import com.facundoduarte.mvc.mvc.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class PersonController {
    private final PersonService personService;
    private final LicenseService licenseService;

    public PersonController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person p) {
        return "createPerson";
    }

    @RequestMapping(value = "/persons/new", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person p, BindingResult result) {
        if (result.hasErrors()) {
            return "createPerson";
        } else {
            personService.creatPerson(p);
            return "redirect:/persons/new";
        }
    }

    @GetMapping("/persons/{id}")
    public String showInformation(Model model, @ModelAttribute("license") License l,
            @ModelAttribute("person") Person p) {
        Person person = personService.findPerson(p.getId());
        model.addAttribute("person", person);
        License license = licenseService.findByPerson(p.getId());
        model.addAttribute("license", license);
        return "showInformation";
    }
}
