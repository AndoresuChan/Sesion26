package com.example.sesion26.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sesion26.models.Interaccion;

@Repository
public interface InteraccionRepository extends JpaRepository<Interaccion, Integer> {
}
