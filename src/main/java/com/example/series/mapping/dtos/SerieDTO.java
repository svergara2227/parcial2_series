// src/main/java/com/example/series/mapping/dtos/SerieDTO.java
package com.example.series.mapping.dtos;

import lombok.Builder;

import java.util.List;


@Builder
public record SerieDTO(
        Long id,
        String nombre,
        String descripcion,
        String creador,
        String clasificacion,
        int numeroTemporadas,
        int anioEmision,
        String imagenPoster,
        List<TemporadaDTO> temporadas,
        List<PersonajeDTO> personajes,
        List<ActorDTO> actores
) {
}