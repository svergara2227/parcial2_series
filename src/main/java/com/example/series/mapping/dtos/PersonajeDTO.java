// src/main/java/com/example/series/mapping/dtos/PersonajeDTO.java
package com.example.series.mapping.dtos;


import lombok.Builder;

@Builder
public record PersonajeDTO(
        Long id,
        String nombre,
        String descripcion,
        String foto,
        Long serieId,
        Long actorId
) {
}