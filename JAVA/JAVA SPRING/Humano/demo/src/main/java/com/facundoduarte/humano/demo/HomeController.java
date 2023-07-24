package com.facundoduarte.humano.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @RequestMapping("/")
    public String greetHuman(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "lastName", required = false) String lastName) {
        if (name == null) {
            return "Hello Human!";
        } else if (lastName == null) {
            return "Hello " + name + "!";
        } else {
            return "Hello " + name + " " + lastName + "!";
        }
    }
}
