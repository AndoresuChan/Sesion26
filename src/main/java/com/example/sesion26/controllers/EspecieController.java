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
import com.example.sesion26.models.Especie;
import com.example.sesion26.services.EspecieService;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @GetMapping
    public List<Especie> getAllEspecies() {
        return especieService.findAll();
    }

    @GetMapping("/{id}")
    public Especie getEspecieById(@PathVariable Integer id) {
        return especieService.findById(id);
    }

    @PostMapping
    public Especie createEspecie(@RequestBody Especie especie) {
        return especieService.save(especie);
    }

    @PutMapping("/{id}")
    public Especie updateEspecie(@PathVariable Integer id, @RequestBody Especie especie) {
        Especie existingEspecie = especieService.findById(id);
        if (existingEspecie != null) {
            existingEspecie.setNombre(especie.getNombre());
            return especieService.save(existingEspecie);
        } else {
            return null; // Handle the case where the especie doesn't exist
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEspecie(@PathVariable Integer id) {
        especieService.deleteById(id);
    }
}
