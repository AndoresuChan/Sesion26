package com.example.sesion26.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CampeonHasInteraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "campeon_id_campeon")
    private Campeon campeon;

    @ManyToOne
    @JoinColumn(name = "campeon_counter_id_counter")
    private Counter campeonCounter;

    @ManyToOne
    @JoinColumn(name = "interaccion_id_interaccion")
    private Interaccion interaccion;

}