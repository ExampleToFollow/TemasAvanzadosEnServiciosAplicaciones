package com.example.proyectotemasavanzados.Controller;

import com.example.proyectotemasavanzados.Beans.Dato;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value="/Inicio")
    public String hola(Model model){
        ArrayList<Dato> listaDatos = new ArrayList<Dato>();
        Dato ola  = new Dato();
        model.addAttribute("listaDatos",listaDatos);
        return "/inicio";
    }
}
