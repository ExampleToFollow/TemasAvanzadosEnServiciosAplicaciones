package com.example.proyectotemasavanzados.Controller;

import com.example.proyectotemasavanzados.Entity.Dato;
import com.example.proyectotemasavanzados.Repository.DatoRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final DatoRepository datoRepository;
    public HomeController(DatoRepository datoRepository) {
        this.datoRepository = datoRepository;
    }

    @GetMapping(value={"/Inicio","/Inicio/"})
    public String Home(Model model) {
        List<Dato> listaDatos = datoRepository.findAll();
        model.addAttribute("listaDatos",listaDatos);
        return "Home";
    }

    @GetMapping(value="/Inicio/{nombreSalon}")
    public String hola(Model model, @PathVariable(value = "nombreSalon")String nombreSalon) {
        model.addAttribute("nombreSalon", nombreSalon);
        if (!nombreSalon.equals("V305") && !nombreSalon.equals("V306") && !nombreSalon.equals("V307")) {
            return "redirect:/Inicio/V305";
        } else {
            return "Inicio";
        }
    }
}
