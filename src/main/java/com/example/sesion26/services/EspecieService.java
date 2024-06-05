package com.example.sesion26.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sesion26.models.Especie;
import com.example.sesion26.repositories.EspecieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    public List<Especie> findAll() {
        return especieRepository.findAll();
    }

    public Especie findById(Integer id) {
        Optional<Especie> optional = especieRepository.findById(id);
        return optional.orElse(null);
    }

    public Especie save(Especie especie) {
        return especieRepository.save(especie);
    }

    public void deleteById(Integer id) {
        especieRepository.deleteById(id);
    }
}
