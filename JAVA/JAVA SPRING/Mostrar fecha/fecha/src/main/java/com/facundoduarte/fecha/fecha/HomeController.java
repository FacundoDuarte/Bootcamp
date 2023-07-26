package com.facundoduarte.fecha.fecha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.ui.Model;

@Controller

public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/date")
    public String date(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormatted = new SimpleDateFormat("EEEE, dd 'of' MMMM 'of' yyyy");
        model.addAttribute("dateFormatted", dateFormatted.format(date));
        return "date";
    }

    int contador = 0;

    @GetMapping("/time")
    public String time(Model model, HttpSession session) {

        session.setAttribute("count", contador++);
        Integer count = (Integer) session.getAttribute("count");

        Date dateTime = new Date();
        SimpleDateFormat timeFormatted = new SimpleDateFormat("hh:mm a");
        model.addAttribute("timeFormatted", timeFormatted.format(dateTime));
        model.addAttribute("count", count);
        return "time";
    }
}
