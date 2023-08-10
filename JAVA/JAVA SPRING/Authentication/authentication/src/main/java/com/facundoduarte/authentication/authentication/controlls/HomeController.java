package com.facundoduarte.authentication.authentication.controlls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.facundoduarte.authentication.authentication.models.User;
import com.facundoduarte.authentication.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registration";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "registration";
        } else {
            User newUser = userService.registerUser(user);
            // Guardar el ID del usuario en el objeto de sesión
            session.setAttribute("userId", newUser.getId());
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
            HttpSession session) {
        if (userService.authenticateUser(email, password)) {
            User registeredUser = userService.findByEmail(email);
            session.setAttribute("userId", registeredUser.getId());
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Datos incorrectos, ingreselos nuevamente");
            return "login";
        }

    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("userId");
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidar la sesión
        // redireccionar a la página de inicio de sesión.
        session.invalidate();
        return "redirect:/login";

    }
}
