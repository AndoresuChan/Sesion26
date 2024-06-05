package com.example.sesion26.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sesion26.models.CampeonHasInteraccion;

@Repository
public interface CampeonHasInteraccionRepository extends JpaRepository<CampeonHasInteraccion, Integer> {
}
