package com.facundoduarte.codigo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping(value = "code", method = RequestMethod.POST)
    public String index(@RequestParam(value = "code") String code, RedirectAttributes redirectAttributes) {
        if (code.equalsIgnoreCase("bushido")) {
            return "code";
        } else {
            redirectAttributes.addFlashAttribute("error", "Debes entrenar mas duro!");
            return "redirect:/";
        }
    }
}
