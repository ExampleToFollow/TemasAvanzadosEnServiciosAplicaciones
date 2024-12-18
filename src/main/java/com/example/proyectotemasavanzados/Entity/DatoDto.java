package com.example.proyectotemasavanzados.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.math.BigDecimal;

public interface DatoDto{
    Integer getId();
    String getIdDispositivo();
    String getTimestamp();
    BigDecimal getTemperatura();
    BigDecimal getHumedad();
}
