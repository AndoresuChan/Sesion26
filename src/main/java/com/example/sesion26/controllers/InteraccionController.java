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

import com.example.sesion26.models.Interaccion;
import com.example.sesion26.services.InteraccionService;

@RestController
@RequestMapping("/api/interacciones")
public class InteraccionController {

    @Autowired
    private InteraccionService interaccionService;

    @GetMapping
    public List<Interaccion> getAllInteracciones() {
        return interaccionService.findAll();
    }

    @GetMapping("/{id}")
    public Interaccion getInteraccionById(@PathVariable Integer id) {
        return interaccionService.findById(id);
    }

    @PostMapping
    public Interaccion createInteraccion(@RequestBody Interaccion interaccion) {
        return interaccionService.save(interaccion);
    }

    @PutMapping("/{id}")
    public Interaccion updateInteraccion(@PathVariable Integer id, @RequestBody Interaccion interaccion) {
        Interaccion existingInteraccion = interaccionService.findById(id);
        if (existingInteraccion != null) {
            existingInteraccion.setNombreInteraccion(interaccion.getNombreInteraccion());
            existingInteraccion.setLimiteInteraccion(interaccion.getLimiteInteraccion());
            return interaccionService.save(existingInteraccion);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteInteraccion(@PathVariable Integer id) {
        interaccionService.deleteById(id);
    }
}
