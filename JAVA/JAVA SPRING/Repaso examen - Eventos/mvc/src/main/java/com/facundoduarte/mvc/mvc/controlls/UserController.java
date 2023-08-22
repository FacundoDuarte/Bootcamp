package com.facundoduarte.mvc.mvc.controlls;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.facundoduarte.mvc.mvc.models.Event;
import com.facundoduarte.mvc.mvc.models.State;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.EventService;
import com.facundoduarte.mvc.mvc.services.StateService;
import com.facundoduarte.mvc.mvc.services.UserService;
import com.facundoduarte.mvc.mvc.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;
    private final StateService stateService;
    private final UserValidator userValidator;
    private EventService eventService;

    public UserController(UserService userService, StateService stateService, UserValidator userValidator,
            EventService eventService) {
        this.userService = userService;
        this.stateService = stateService;
        this.eventService = eventService;
        this.userValidator = userValidator;
    }

    @GetMapping(value = "/")
    public String registerForm(@ModelAttribute("user") User user, Model model) {

        List<State> listStates = stateService.allStates();
        model.addAttribute("states", listStates);
        return "form";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,
            BindingResult result, HttpSession session, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            List<State> listStates = stateService.allStates();
            model.addAttribute("states", listStates);
            return "form";
        } else {
            User newUser = userService.registerUser(user);
            session.setAttribute("userId", newUser.getId());
            return "redirect:/index";
        }
    }

    @GetMapping(value = "/login")
    public String loginForm() {
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
            HttpSession session, RedirectAttributes redirectAttributes) {
        if (userService.authenticateUser(email, password)) {
            User registeredUser = userService.findByEmail(email);
            session.setAttribute("userId", registeredUser.getId());
            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("error", "Datos incorrectos, ingreselos nuevamente *");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/index")
    public String index(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("userId");
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        List<State> listStates = stateService.allStates();
        model.addAttribute("states", listStates);
        List<Event> listEvents = eventService.allEvents(user);
        model.addAttribute("events", listEvents);
        List<Event> listEventsByState = eventService.allEventsByState(id);
        model.addAttribute("eventsByState", listEventsByState);
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
