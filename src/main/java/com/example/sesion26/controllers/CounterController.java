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
import com.example.sesion26.models.Counter;
import com.example.sesion26.services.CounterService;

@RestController
@RequestMapping("/api/counters")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @GetMapping
    public List<Counter> getAllCounters() {
        return counterService.findAll();
    }

    @GetMapping("/{id}")
    public Counter getCounterById(@PathVariable Integer id) {
        return counterService.findById(id);
    }

    @PostMapping
    public Counter createCounter(@RequestBody Counter counter) {
        return counterService.save(counter);
    }

    @PutMapping("/{id}")
    public Counter updateCounter(@PathVariable Integer id, @RequestBody Counter counter) {
        Counter existingCounter = counterService.findById(id);
        if (existingCounter != null) {
            existingCounter.setNombre(counter.getNombre());
            existingCounter.setPorcentajeVictoria(counter.getPorcentajeVictoria());
            existingCounter.setPorcentajeDerrota(counter.getPorcentajeDerrota());
            existingCounter.setNacionalidad(counter.getNacionalidad());
            existingCounter.setEspecie(counter.getEspecie());
            return counterService.save(existingCounter);
        } else {
            return null; 
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCounter(@PathVariable Integer id) {
        counterService.deleteById(id);
    }
}
