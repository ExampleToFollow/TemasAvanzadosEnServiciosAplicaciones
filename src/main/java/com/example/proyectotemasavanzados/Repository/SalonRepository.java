package com.example.proyectotemasavanzados.Repository;

import com.example.proyectotemasavanzados.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalonRepository extends JpaRepository<Salon, Integer> {
    @Query(nativeQuery = true,value="select id from salon where nombre=?1 and password=sha2(?2,256)")
    Integer verificarIdSalon(String nombre,String password);
}