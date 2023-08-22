package com.facundoduarte.mvc.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.facundoduarte.mvc.mvc.models.Idea;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.IdeaService;
import com.facundoduarte.mvc.mvc.services.LikeService;
import com.facundoduarte.mvc.mvc.services.UserService;
import com.facundoduarte.mvc.mvc.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final IdeaService ideaService;
    private final LikeService likeService;

    public HomeController(UserService userService, UserValidator userValidator, IdeaService ideaService,
            LikeService likeService) {
        this.userService = userService;
        this.ideaService = ideaService;
        this.userValidator = userValidator;
        this.likeService = likeService;
    }

    @GetMapping(value = "/")
    public String registerForm(@ModelAttribute("user") User user, Model model) {
        return "form";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,
            BindingResult result, @RequestParam("email") String email, RedirectAttributes redirectAttributes,
            HttpSession session, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "form";
        } else if (userService.checkEmail(email)) {
            result.rejectValue("user.email", "Correo electronico ya ingresado");
            redirectAttributes.addFlashAttribute("error", "Correo electronico ya ingresado");
            return "redirect:/";
        } else {
            User newUser = userService.registerUser(user);
            session.setAttribute("userId", newUser.getId());
            return "redirect:/ideas";
        }

    }

    @GetMapping(value = "/login")
    public String loginForm(HttpSession session) {
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpSession session, RedirectAttributes redirectAttributes) {
        if (userService.authenticateUser(email, password)) {
            User registeredUser = userService.findByEmail(email);
            session.setAttribute("userId", registeredUser.getId());
            return "redirect:/ideas";
        } else {
            redirectAttributes.addFlashAttribute("error", "Datos incorrectos, ingreselos nuevamente *");
            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";

    }

    @RequestMapping(value = "/ideas")
    public String index(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("userId");
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        List<Idea> ideasWithLikesAndCurrentUser = ideaService.getAllIdeasWithLikesAndCurrentUser(user);
        model.addAttribute("ideasWithLikesAndCurrentUser", ideasWithLikesAndCurrentUser);
        return "ideas";
    }

    @GetMapping(value = "/ideas/new")
    public String loginIdea(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("userId");
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "newIdea";
    }

    @RequestMapping(value = "/ideas/new", method = RequestMethod.POST)
    public String createIdea(@Valid @ModelAttribute("idea") Idea idea, Model model, BindingResult result,
            HttpSession session, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "newIdea";
        } else {
            Long id = (Long) session.getAttribute("userId");
            User user = userService.findUserById(id);
            idea.setUser(user);
            ideaService.createIdea(idea);
            return "redirect:/ideas/new";
        }
    }

    @PostMapping("/ideas/{id}/like")
    public String likeIdea(@PathVariable Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Idea idea = ideaService.findIdea(id);
        likeService.likeIdea(idea, user);

        return "redirect:/ideas";
    }

    @PostMapping("/ideas/{id}/dislike")
    public String dislikeIdea(@PathVariable Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Idea idea = ideaService.findIdea(id);
        likeService.dislikeIdea(idea, user);

        return "redirect:/ideas";
    }

    @GetMapping(value = "/ideas/{id}")
    public String ideaInformation(@PathVariable Long id, Model model) {
        Idea idea = ideaService.findIdea(id);
        if (idea == null) {
            return "redirect:/ideas";
        } else {
            model.addAttribute("idea", idea);
            return "idea";
        }
    }

    @GetMapping(value = "/ideas/{id}/edit")
    public String showEditIdea(@PathVariable Long id, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Idea idea = ideaService.findIdea(id);
        if (idea == null || !idea.getUser().equals(user)) {
            return "redirect:/ideas";
        } else {
            model.addAttribute("idea", idea);
            return "updateIdea";
        }
    }

    @PostMapping(value = "/ideas/{id}/edit")
    public String editIdea(@PathVariable Long id, @ModelAttribute Idea idea) {
        Idea existingIdea = ideaService.findIdea(id);
        existingIdea.setTextIdea(idea.getTextIdea());
        ideaService.createIdea(existingIdea);
        return "redirect:/ideas/" + id;
    }

    @PostMapping(value = "/ideas/{id}/delete")
    public String deleteIdea(@PathVariable("id") Long id, HttpSession session) {
        likeService.deleteLikeByIdea(id);
        ideaService.deleteIdea(id);
        return "redirect:/ideas";
    }

}
