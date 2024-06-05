package com.example.sesion26.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sesion26.models.Campeon;
import com.example.sesion26.services.CampeonService;

@RestController
@RequestMapping("/api/campeones")
public class CampeonController {

    @Autowired
    private CampeonService campeonService;

    @GetMapping
    public List<Campeon> getAllCampeones() {
        return campeonService.findAll();
    }

    @GetMapping("/{id}")
    public Campeon getCampeonById(@PathVariable Integer id) {
        return campeonService.findById(id);
    }

    @PostMapping
    public Campeon createCampeon(@RequestBody Campeon campeon) {
        return campeonService.save(campeon);
    }

    @PutMapping("/{id}")
    public Campeon updateCampeon(@PathVariable Integer id, @RequestBody Campeon campeon) {
        Campeon existingCampeon = campeonService.findById(id);
        if (existingCampeon != null) {
            existingCampeon.setNombre(campeon.getNombre());
            existingCampeon.setTipoAtaque(campeon.getTipoAtaque());
            existingCampeon.setVidaBase(campeon.getVidaBase());
            existingCampeon.setManaBool(campeon.isManaBool());
            existingCampeon.setEnergiaBool(campeon.isEnergiaBool());
            existingCampeon.setVelocidadAtaqueBase(campeon.getVelocidadAtaqueBase());
            existingCampeon.setVelocidadMovimientoBase(campeon.getVelocidadMovimientoBase());
            existingCampeon.setNacionalidad(campeon.getNacionalidad());
            existingCampeon.setEspecie(campeon.getEspecie());
            existingCampeon.setCounter(campeon.getCounter());
            existingCampeon.setRival(campeon.getRival());
            return campeonService.save(existingCampeon);
        } else {
            return null; 
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCampeon(@PathVariable Integer id) {
        campeonService.deleteById(id);
    }
}
