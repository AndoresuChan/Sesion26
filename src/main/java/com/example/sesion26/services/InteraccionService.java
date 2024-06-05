package com.example.sesion26.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sesion26.models.Interaccion;
import com.example.sesion26.repositories.InteraccionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InteraccionService {

    @Autowired
    private InteraccionRepository interaccionRepository;

    public List<Interaccion> findAll() {
        return interaccionRepository.findAll();
    }

    public Interaccion findById(Integer id) {
        Optional<Interaccion> optional = interaccionRepository.findById(id);
        return optional.orElse(null);
    }

    public Interaccion save(Interaccion interaccion) {
        return interaccionRepository.save(interaccion);
    }

    public void deleteById(Integer id) {
        interaccionRepository.deleteById(id);
    }
}
