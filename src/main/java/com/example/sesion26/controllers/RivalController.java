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

import com.example.sesion26.models.Rival;
import com.example.sesion26.services.RivalService;

@RestController
@RequestMapping("/api/rivales")
public class RivalController {

    @Autowired
    private RivalService rivalService;

    @GetMapping
    public List<Rival> getAllRivales() {
        return rivalService.findAll();
    }

    @GetMapping("/{id}")
    public Rival getRivalById(@PathVariable Integer id) {
        return rivalService.findById(id);
    }

    @PostMapping
    public Rival createRival(@RequestBody Rival rival) {
        return rivalService.save(rival);
    }

    @PutMapping("/{id}")
    public Rival updateRival(@PathVariable Integer id, @RequestBody Rival rival) {
        Rival existingRival = rivalService.findById(id);
        if (existingRival != null) {
            existingRival.setNombre(rival.getNombre());
            existingRival.setNacionalidad(rival.getNacionalidad());
            existingRival.setEspecie(rival.getEspecie());
            return rivalService.save(existingRival);
        } else {
            return null; 
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRival(@PathVariable Integer id) {
        rivalService.deleteById(id);
    }
}
