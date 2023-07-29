package com.facundoduarte.ninjagold.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    int oro = 0;
    Random random = new Random();
    private List<String> registro = new ArrayList<>();
    String mensaje;

    public int randomNum(int min, int max) {
        int goldFarm = random.nextInt(max - min + 1) + min;
        return goldFarm;
    }

    public void winCondition(Model model, int min, int max, String place) {
        Date date = new Date();
        int goldFarm = randomNum(min, max);
        oro += goldFarm;
        SimpleDateFormat dateFormatted = new SimpleDateFormat("MMMM dd yyyy hh:mm a");
        mensaje = "Has ganado " + goldFarm + " de oro en la" + place + "(" + dateFormatted.format(date) + ")";
        registro.add(mensaje);
        model.addAttribute("oro", oro);
        model.addAttribute("registro", registro);
        model.addAttribute("class", "win");
    }

    public void loseCondition(Model model, int min, int max, String place) {
        Date date = new Date();
        int goldFarm = randomNum(min, max);
        oro -= goldFarm;
        SimpleDateFormat dateFormatted = new SimpleDateFormat("MMMM dd yyyy hh:mm a ");
        mensaje = "Has perdido " + goldFarm + " de oro en la " + place + " (" + dateFormatted.format(date) + ")";
        registro.add(mensaje);
        model.addAttribute("oro", oro);
        model.addAttribute("registro", registro);
        model.addAttribute("class", "lose");
    }

    @RequestMapping(value = "/granja", method = RequestMethod.POST)
    public String granja(Model model) {
        winCondition(model, 10, 20, "granja");
        return "index";
    }

    @RequestMapping(value = "/cueva", method = RequestMethod.POST)
    public String cueva(Model model) {
        winCondition(model, 5, 10, "cueva");
        return "index";
    }

    @RequestMapping(value = "/casa", method = RequestMethod.POST)
    public String casa(Model model) {
        winCondition(model, 2, 5, "casa");
        return "index";
    }

    @RequestMapping(value = "/casino", method = RequestMethod.POST)
    public String casino(Model model) {
        int winOrLose = randomNum(0, 1);
        if (winOrLose == 1) {
            loseCondition(model, 0, 50, "casino");
        } else {
            winCondition(model, 0, 50, "casino");
        }
        return "index";
    }
}
