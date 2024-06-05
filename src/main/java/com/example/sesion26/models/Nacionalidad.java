package com.example.sesion26.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Nacionalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNacionalidad;

    @Enumerated(EnumType.STRING)
    private String nombre;

    @OneToMany(mappedBy = "nacionalidad")
    private List<Campeon> campeones;

    public Integer getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Campeon> getCampeones() {
        return campeones;
    }

    public void setCampeones(List<Campeon> campeones) {
        this.campeones = campeones;
    }
}
