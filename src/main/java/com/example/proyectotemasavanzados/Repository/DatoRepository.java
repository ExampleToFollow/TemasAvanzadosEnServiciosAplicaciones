package com.example.proyectotemasavanzados.Repository;

import com.example.proyectotemasavanzados.Entity.Dato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatoRepository extends JpaRepository<Dato, Integer> {
    List<Dato> findBySalonNombre(String nombreSalon);


    @Query(nativeQuery = true,value = "select d.* from datos d inner join salon s on d.id_salon=s.id where s.nombre=?1 order by d.timestamp desc")
    List<Dato> listarDatosPorSalon(String salon);
}
