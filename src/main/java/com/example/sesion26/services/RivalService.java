package com.example.sesion26.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sesion26.models.Rival;
import com.example.sesion26.repositories.RivalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RivalService {

    @Autowired
    private RivalRepository rivalRepository;

    public List<Rival> findAll() {
        return rivalRepository.findAll();
    }

    public Rival findById(Integer id) {
        Optional<Rival> optional = rivalRepository.findById(id);
        return optional.orElse(null);
    }

    public Rival save(Rival rival) {
        return rivalRepository.save(rival);
    }

    public void deleteById(Integer id) {
        rivalRepository.deleteById(id);
    }
}
