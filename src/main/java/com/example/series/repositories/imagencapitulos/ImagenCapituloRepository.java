package com.example.series.repositories.imagencapitulos;

import com.example.series.domain.entities.ImagenCapitulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagenCapituloRepository extends JpaRepository<ImagenCapitulo, Long> {
    List<ImagenCapitulo> findByCapituloId(Long capituloId);
}
