package com.example.sesion26.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sesion26.models.CampeonHasInteraccion;
import com.example.sesion26.services.CampeonHasInteraccionService;

import java.util.List;

@RestController
@RequestMapping("/api/campeon-interacciones")
public class CampeonHasInteraccionController {

    @Autowired
    private CampeonHasInteraccionService campeonHasInteraccionService;

    @GetMapping
    public List<CampeonHasInteraccion> getAllCampeonHasInteracciones() {
        return campeonHasInteraccionService.findAll();
    }

    @GetMapping("/{id}")
    public CampeonHasInteraccion getCampeonHasInteraccionById(@PathVariable Integer id) {
        return campeonHasInteraccionService.findById(id);
    }

    @PostMapping
    public CampeonHasInteraccion createCampeonHasInteraccion(@RequestBody CampeonHasInteraccion campeonHasInteraccion) {
        return campeonHasInteraccionService.save(campeonHasInteraccion);
    }

    @PutMapping("/{id}")
    public CampeonHasInteraccion updateCampeonHasInteraccion(@PathVariable Integer id, @RequestBody CampeonHasInteraccion campeonHasInteraccion) {
        CampeonHasInteraccion existingCampeonHasInteraccion = campeonHasInteraccionService.findById(id);
        if (existingCampeonHasInteraccion != null) {
            existingCampeonHasInteraccion.setCampeon(campeonHasInteraccion.getCampeon());
            existingCampeonHasInteraccion.setCounter(campeonHasInteraccion.getCounter());
            existingCampeonHasInteraccion.setInteraccion(campeonHasInteraccion.getInteraccion());
            return campeonHasInteraccionService.save(existingCampeonHasInteraccion);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCampeonHasInteraccion(@PathVariable Integer id) {
        campeonHasInteraccionService.deleteById(id);
    }
}
