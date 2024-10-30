package com.example.proyectotemasavanzados.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "datos")
public class Dato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_salon", nullable = false)
    private Salon salon;

    @Column(name = "id_dispositivo", nullable = false, length = 1000)
    private String idDispositivo;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @Column(name = "temperatura", nullable = false, precision = 10, scale = 1)
    private BigDecimal temperatura;

    @Column(name = "humedad", nullable = false, precision = 10, scale = 1)
    private BigDecimal humedad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }



    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public BigDecimal getHumedad() {
        return humedad;
    }

    public void setHumedad(BigDecimal humedad) {
        this.humedad = humedad;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}