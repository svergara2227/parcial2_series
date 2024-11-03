// src/main/java/com/example/series/mapping/dtos/ActorDTO.java
package com.example.series.mapping.dtos;

import lombok.Builder;

import java.util.List;


@Builder
public record ActorDTO(
        Long id,
        String nombre,
        String biografia,
        String foto,
        List<PersonajeDTO> personajes,
        List<SerieDTO> series
) {
}