package com.example.sesion26.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sesion26.models.CampeonHasInteraccion;
import com.example.sesion26.repositories.CampeonHasInteraccionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonHasInteraccionService {

    @Autowired
    private CampeonHasInteraccionRepository campeonHasInteraccionRepository;

    public List<CampeonHasInteraccion> findAll() {
        return campeonHasInteraccionRepository.findAll();
    }

    public CampeonHasInteraccion findById(Integer id) {
        Optional<CampeonHasInteraccion> optional = campeonHasInteraccionRepository.findById(id);
        return optional.orElse(null);
    }

    public CampeonHasInteraccion save(CampeonHasInteraccion campeonHasInteraccion) {
        return campeonHasInteraccionRepository.save(campeonHasInteraccion);
    }

    public void deleteById(Integer id) {
        campeonHasInteraccionRepository.deleteById(id);
    }
}
