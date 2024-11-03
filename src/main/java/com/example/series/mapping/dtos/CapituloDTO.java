// src/main/java/com/example/series/mapping/dtos/CapituloDTO.java
package com.example.series.mapping.dtos;

import lombok.Builder;

import java.util.List;


@Builder
public record CapituloDTO(
        Long id,
        int numeroCapitulo,
        String nombre,
        String descripcion,
        double calificacionPromedio,
        Long temporadaId,
        List<ImagenCapituloDTO> imagenes
) {
}