package com.facundoduarte.mvc.mvc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoduarte.mvc.mvc.models.License;
import com.facundoduarte.mvc.mvc.models.Person;
import com.facundoduarte.mvc.mvc.services.LicenseService;
import com.facundoduarte.mvc.mvc.services.PersonService;
import com.facundoduarte.mvc.mvc.util.LicenseNumberGenerator;

import jakarta.validation.Valid;

@Controller
public class LicenseController {
    private final LicenseService licenseService;
    private final PersonService personService;
    private LicenseNumberGenerator licenseNumberGenerator;

    public LicenseController(LicenseService licenseService, PersonService personService,
            LicenseNumberGenerator licenseNumberGenerator) {
        this.licenseService = licenseService;
        this.personService = personService;
        this.licenseNumberGenerator = licenseNumberGenerator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License l, @ModelAttribute("person") Person p,
            Model model) {
        List<Person> allPersons = personService.allPersons();
        model.addAttribute("persons", allPersons);
        return "createLicense";
    }

    @RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License l, BindingResult result) {
        if (result.hasErrors()) {
            return "createLicense";
        } else {
            String numeroLicencia = licenseNumberGenerator.generateLicenseNumber();
            l.setNumber(numeroLicencia);
            licenseService.createLicense(l);
            return "redirect:/licenses/new";
        }
    }
}
