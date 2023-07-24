package com.facundoduarte.fecha.fecha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/time")
    public String time(Model model) {
        Date dateTime = new Date();
        SimpleDateFormat timeFormatted = new SimpleDateFormat("hh:mm a");
        model.addAttribute("timeFormatted", timeFormatted.format(dateTime));
        return "time";
    }
}
