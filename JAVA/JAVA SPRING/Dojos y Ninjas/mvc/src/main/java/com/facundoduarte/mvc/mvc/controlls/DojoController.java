package com.facundoduarte.mvc.mvc.controlls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facundoduarte.mvc.mvc.models.Dojo;
import com.facundoduarte.mvc.mvc.services.DojoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo";
    }

    @RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }

    @RequestMapping("/dojos/{id}")
    public String showDojo(@ModelAttribute("dojo") Dojo d, Model model) {
        Dojo dojo = dojoService.findDojo(d.getId());
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", dojo.getNinjas());

        return "showInformation";
    }

}
