// src/main/java/com/example/series/mapping/dtos/ImagenCapituloDTO.java
package com.example.series.mapping.dtos;


import lombok.Builder;

@Builder
public record ImagenCapituloDTO(
        Long id,
        String url,
        Long capituloId
) {
}