package com.example.proyectotemasavanzados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping(value="/Inicio")
    public String hola(){

        return "Hola";
    }


}
