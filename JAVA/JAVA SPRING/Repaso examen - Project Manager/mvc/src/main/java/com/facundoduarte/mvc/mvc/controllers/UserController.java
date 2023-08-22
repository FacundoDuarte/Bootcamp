package com.facundoduarte.mvc.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.UserService;
import com.facundoduarte.mvc.mvc.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping(value = "/")
    public String index(@ModelAttribute("user") User user) {
        return "index";
    }

    @GetMapping(value = "/signin")
    public String signIn() {
        return "redirect:/";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signIn(@Valid @ModelAttribute("user") User user,
            BindingResult result, RedirectAttributes redirectAttributes, HttpSession session, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "index";
        } else {
            if (userService.checkEmail(user.getEmail())) {
                result.rejectValue("email", "Correo electronico ya ingresado");
                redirectAttributes.addFlashAttribute("error", "Correo electronico ya ingresado");
                return "redirect:/";
            } else {
                User newUser = userService.registerUser(user);
                session.setAttribute("userId", newUser.getId());
                return "redirect:/dashboard";
            }
        }
    }

    @GetMapping(value = "/login")
    public String login() {
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpSession session, RedirectAttributes redirectAttributes) {
        if (userService.authenticateUser(email, password)) {
            User registeredUser = userService.findByEmail(email);
            session.setAttribute("userId", registeredUser.getId());
            return "redirect:/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("login_error", "Datos incorrectos, ingreselos nuevamente *");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
