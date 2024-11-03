// src/main/java/com/example/series/mapping/dtos/TemporadaDTO.java
package com.example.series.mapping.dtos;

import lombok.Builder;
import java.util.List;

@Builder
public record TemporadaDTO(
        Long id,
        int numeroTemporada,
        int anioLanzamiento,

        Long serieId,
        List<CapituloDTO> capitulos
) {
}