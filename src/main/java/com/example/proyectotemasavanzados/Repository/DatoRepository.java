package com.example.proyectotemasavanzados.Repository;

import com.example.proyectotemasavanzados.Entity.Dato;
import com.example.proyectotemasavanzados.Entity.DatoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatoRepository extends JpaRepository<Dato, Integer> {
    List<Dato> findBySalonNombre(String nombreSalon);


    @Query(nativeQuery = true,value = "select d.id as 'id',d.id_dispositivo as 'id_dispositivo',DATE_FORMAT(d.timestamp, '%Y-%m-%d %H:%i:%s') AS 'timestamp',d.temperatura as 'temperatura',d.humedad as 'humedad' from datos d inner join salon s on d.id_salon=s.id where s.nombre=?1 order by timestamp desc")
    List<DatoDto> listarDatosPorSalon(String salon);
}
