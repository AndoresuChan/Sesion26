package com.example.sesion26.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sesion26.models.Counter;
import com.example.sesion26.repositories.CounterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    public List<Counter> findAll() {
        return counterRepository.findAll();
    }

    public Counter findById(Integer id) {
        Optional<Counter> optional = counterRepository.findById(id);
        return optional.orElse(null);
    }

    public Counter save(Counter counter) {
        return counterRepository.save(counter);
    }

    public void deleteById(Integer id) {
        counterRepository.deleteById(id);
    }
}
