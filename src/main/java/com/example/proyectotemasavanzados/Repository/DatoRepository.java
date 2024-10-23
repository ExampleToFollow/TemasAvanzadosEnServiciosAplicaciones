package com.example.proyectotemasavanzados.Repository;

import com.example.proyectotemasavanzados.Beans.Dato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoRepository extends JpaRepository<Dato, Integer> {

}