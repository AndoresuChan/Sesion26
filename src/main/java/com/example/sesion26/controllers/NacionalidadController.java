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
import com.example.sesion26.models.Nacionalidad;

@RestController
@RequestMapping("/api/nacionalidades")
public class NacionalidadController {

    @Autowired
    private NacionalidadService nacionalidadService;

    @GetMapping
    public List<Nacionalidad> getAllNacionalidades() {
        return nacionalidadService.findAll();
    }

    @GetMapping("/{id}")
    public Nacionalidad getNacionalidadById(@PathVariable Integer id) {
        return nacionalidadService.findById(id);
    }

    @PostMapping
    public Nacionalidad createNacionalidad(@RequestBody Nacionalidad nacionalidad) {
        return nacionalidadService.save(nacionalidad);
    }

    @PutMapping("/{id}")
    public Nacionalidad updateNacionalidad(@PathVariable Integer id, @RequestBody Nacionalidad nacionalidad) {
        Nacionalidad existingNacionalidad = nacionalidadService.findById(id);
        if (existingNacionalidad != null) {
            existingNacionalidad.setNombre(nacionalidad.getNombre());
            return nacionalidadService.save(existingNacionalidad);
        } else {
            return null; 
        }
    }

    @DeleteMapping("/{id}")
    public void deleteNacionalidad(@PathVariable Integer id) {
        nacionalidadService.deleteById(id);
    }
}
