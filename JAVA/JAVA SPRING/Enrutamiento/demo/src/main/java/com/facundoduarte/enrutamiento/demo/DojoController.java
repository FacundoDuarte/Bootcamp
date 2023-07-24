package com.facundoduarte.enrutamiento.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DojoController {

    @RequestMapping("{track}")
    public String dojo(@PathVariable("track") String track) {
        String response = "";
        if (track.equalsIgnoreCase("dojo")) {
            response = "¡El Dojo es increíble!";
        } else if (track.equalsIgnoreCase("burbank-dojo")) {
            response = "El Dojo Burbank esta localizado al sur de California";
        } else if (track.equalsIgnoreCase("san-jose")) {
            response = "El Dojo SJ es el cuartel general";
        }
        return response;
    }

}
