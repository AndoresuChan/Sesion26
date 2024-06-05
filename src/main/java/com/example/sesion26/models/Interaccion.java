package com.example.sesion26.models;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Interaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInteraccion;

    private String nombreInteraccion;
    private Integer limiteInteraccion;

    @OneToMany(mappedBy = "interaccion")
    private Set<CampeonHasInteraccion> campeonHasInteracciones;

}