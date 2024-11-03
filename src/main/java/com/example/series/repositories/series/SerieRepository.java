package com.example.series.repositories.series;

import com.example.series.domain.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
