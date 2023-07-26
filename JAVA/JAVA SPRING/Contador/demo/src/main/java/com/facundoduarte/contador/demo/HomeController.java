package com.facundoduarte.contador.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    int contador = 0;

    @GetMapping("/")
    public String index(HttpSession session, HttpServletRequest request) {
        session.setAttribute("count", contador++);
        session.setAttribute("url", request.getRequestURL());
        return "index";
    }

    @GetMapping("/counter")
    public String countVisit(@SessionAttribute("count") int count,
            @SessionAttribute("url") String url, Model model) {
        model.addAttribute("count", count);
        model.addAttribute("url", url);
        return "counter";
    }
}
