package com.example.series.repositories.personajes;

import com.example.series.domain.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
}
