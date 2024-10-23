package com.example.proyectotemasavanzados.Service;
import com.example.proyectotemasavanzados.Beans.Dato;
import com.example.proyectotemasavanzados.Repository.DatoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@RestController
public class Service {
    final DatoRepository datoRepository;
    public Service(DatoRepository datoRepository){
        this.datoRepository = datoRepository;
    }
    @PostMapping("/ola")
    public ResponseEntity<HashMap<String, Object>> ola(@RequestBody Map<String, Object> body) {
        String nombre=(String) body.get("nombre");
        System.out.println("Ola " + nombre);
        String idDevice =  "12";
        String timeStamp =  "12";
        String temperatura = "12";
        String humedad = "12";
        Dato dato = new Dato();
        dato.setId(Integer.parseInt(idDevice));
        dato.setTimestamp(Instant.parse(timeStamp));
        dato.setTemperatura(new BigDecimal(temperatura));
        dato.setHumedad(new BigDecimal(humedad));
        datoRepository.save(dato);
        return null;
    }


    @GetMapping("/getDatos")
    public Object getDatos(){
        //Random
        List<Dato> datos = datoRepository.findAll();
        return datos;
    }

}
