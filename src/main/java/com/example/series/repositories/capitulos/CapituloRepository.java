package com.example.series.repositories.capitulos;

import com.example.series.domain.entities.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapituloRepository extends JpaRepository<Capitulo, Long> {
}
