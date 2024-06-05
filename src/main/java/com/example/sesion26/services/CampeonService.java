package com.example.sesion26.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sesion26.models.Campeon;
import com.example.sesion26.repositories.CampeonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonService {

    @Autowired
    private CampeonRepository campeonRepository;

    public List<Campeon> findAll() {
        return campeonRepository.findAll();
    }

    public Campeon findById(Integer id) {
        Optional<Campeon> optional = campeonRepository.findById(id);
        return optional.orElse(null);
    }

    public Campeon save(Campeon campeon) {
        return campeonRepository.save(campeon);
    }

    public void deleteById(Integer id) {
        campeonRepository.deleteById(id);
    }
}
