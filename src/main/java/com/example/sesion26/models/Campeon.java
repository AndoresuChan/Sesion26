package com.example.sesion26.models;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;


@Entity
public class Campeon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCampeon;

    private String tipoAtaque;
    private Integer vidaBase;
    private Boolean manaBool;
    private Boolean energiaBool;
    private Float velocidadAtaqueBase;
    private Float velocidadMovimientoBase;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "nacionalidad_id_nacionalidad")
    private Nacionalidad nacionalidad;

    @ManyToOne
    @JoinColumn(name = "especie_id_especie")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "counter_id_counter")
    private Counter counter;

    @ManyToOne
    @JoinColumn(name = "rival_id_rival")
    private Rival rival;

    @OneToMany(mappedBy = "campeon")
    private Set<CampeonHasInteraccion> campeonHasInteracciones;

}