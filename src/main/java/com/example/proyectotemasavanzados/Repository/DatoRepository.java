package com.example.proyectotemasavanzados.Repository;

import com.example.proyectotemasavanzados.Entity.Dato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatoRepository extends JpaRepository<Dato, Integer> {
    List<Dato> findBySalonNombre(String nombreSalon);
}
