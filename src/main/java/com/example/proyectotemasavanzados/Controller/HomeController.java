package com.example.proyectotemasavanzados.Controller;

import com.example.proyectotemasavanzados.Entity.Dato;
import com.example.proyectotemasavanzados.Repository.DatoRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final DatoRepository datoRepository;
    public HomeController(DatoRepository datoRepository) {
        this.datoRepository = datoRepository;
    }

    @GetMapping(value="/Inicio")
    public String hola(Model model){
        List<Dato> listaDatos = datoRepository.findAll();
        model.addAttribute("listaDatos",listaDatos);
        return "Inicio";
    }
}
