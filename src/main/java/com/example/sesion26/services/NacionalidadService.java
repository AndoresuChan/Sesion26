package com.example.sesion26.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sesion26.models.Nacionalidad;
import com.example.sesion26.repositories.NacionalidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NacionalidadService {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    public List<Nacionalidad> findAll() {
        return nacionalidadRepository.findAll();
    }

    public Nacionalidad findById(Integer id) {
        Optional<Nacionalidad> optional = nacionalidadRepository.findById(id);
        return optional.orElse(null);
    }

    public Nacionalidad save(Nacionalidad nacionalidad) {
        return nacionalidadRepository.save(nacionalidad);
    }

    public void deleteById(Integer id) {
        nacionalidadRepository.deleteById(id);
    }
}
