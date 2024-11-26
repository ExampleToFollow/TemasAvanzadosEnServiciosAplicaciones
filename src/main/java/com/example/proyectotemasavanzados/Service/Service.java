package com.example.proyectotemasavanzados.Service;
import com.example.proyectotemasavanzados.Entity.Dato;
import com.example.proyectotemasavanzados.Entity.Salon;
import com.example.proyectotemasavanzados.Repository.DatoRepository;
import com.example.proyectotemasavanzados.Repository.SalonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class Service {
    final DatoRepository datoRepository;
    private final SalonRepository salonRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public Service(DatoRepository datoRepository, SalonRepository salonRepository, SimpMessagingTemplate simpMessagingTemplate){
        this.datoRepository = datoRepository;
        this.salonRepository = salonRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/registrarDato")
    public ResponseEntity<HashMap<String, Object>> registrarDato(@RequestBody Map<String, Object> body) {
        List<HashMap<String,Object>> lista = (List<HashMap<String, Object>>) body.get("lista");
        for(HashMap<String,Object> elemento: lista){
            String temperatura=(String) elemento.get("Temperatura");
            temperatura=temperatura.split("°")[0];
            String humedad=(String) elemento.get("Humedad");
            String idDevice =  "12";
            String timestamp=(String) elemento.get("Timestamp");
            String salon=(String) elemento.get("Salon");
            String password=(String) elemento.get("Password");
            Integer idSalon=salonRepository.verificarIdSalon(salon,password);
            if(idSalon!=null){
                Dato dato = new Dato();
                if(timestamp==null){
                    dato.setTimestamp(ZonedDateTime.now(ZoneId.of("America/Lima")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }else {
                    dato.setTimestamp(timestamp);
                }
                dato.setSalon(salonRepository.findById(idSalon).get());
                dato.setIdDispositivo(idDevice);
                dato.setTemperatura(new BigDecimal(temperatura));
                dato.setHumedad(new BigDecimal(humedad));
                datoRepository.save(dato);
                simpMessagingTemplate.convertAndSend("/topic/recibirDato",dato);
            }
        }
        return null;
    }


    @GetMapping("/obtenerDatos")
    public ResponseEntity<HashMap<String,Object>> obtenerDatos(){
        HashMap<String,Object>datos=new HashMap<>();
        datos.put("content",datoRepository.findAll());
        datos.put("status","success");
        return ResponseEntity.ok(datos);
    }

    @GetMapping("/datosPorSalon/{salon}")
    public ResponseEntity<HashMap<String, Object>> obtenerDatosPorSalon(@PathVariable String salon) {
        List<Dato> datosFiltrados = datoRepository.findBySalonNombre(salon);
        HashMap<String, Object> response = new HashMap<>();
        response.put("content", datosFiltrados);
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}
