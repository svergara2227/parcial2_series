// src/main/java/com/example/series/mapping/mappers/CapituloMapper.java
package com.example.series.mapping.mappers;

import com.example.series.domain.entities.Capitulo;
import com.example.series.domain.entities.ImagenCapitulo;
import com.example.series.domain.entities.Temporada;
import com.example.series.mapping.dtos.CapituloDTO;
import com.example.series.mapping.dtos.ImagenCapituloDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CapituloMapper {
    public static Capitulo mapFromDto(CapituloDTO capituloDTO) {
        if (capituloDTO == null) {
            return null;
        }

        List<ImagenCapitulo> imagenes = Collections.emptyList();
        if (capituloDTO.imagenes() != null) {
            imagenes = capituloDTO.imagenes()
                    .stream()
                    .map(ImagenCapituloMapper::mapFromDto)
                    .collect(Collectors.toList());
        }

        return Capitulo.builder()
                .id(capituloDTO.id())
                .numeroCapitulo(capituloDTO.numeroCapitulo())
                .nombre(capituloDTO.nombre())
                .descripcion(capituloDTO.descripcion())
                .calificacionPromedio(capituloDTO.calificacionPromedio())
                .temporada(capituloDTO.temporadaId() != null ?
                        Temporada.builder().id(capituloDTO.temporadaId()).build() : null)
                .imagenes(imagenes)
                .build();
    }

    public static CapituloDTO mapFromModel(Capitulo capitulo) {
        if (capitulo == null) {
            return null;
        }

        List<ImagenCapituloDTO> imagenes = Collections.emptyList();
        if (capitulo.getImagenes() != null) {
            imagenes = capitulo.getImagenes()
                    .stream()
                    .map(ImagenCapituloMapper::mapFromModel)
                    .collect(Collectors.toList());
        }

        return CapituloDTO.builder()
                .id(capitulo.getId())
                .numeroCapitulo(capitulo.getNumeroCapitulo())
                .nombre(capitulo.getNombre())
                .descripcion(capitulo.getDescripcion())
                .calificacionPromedio(capitulo.getCalificacionPromedio())
                .temporadaId(capitulo.getTemporada() != null ?
                        capitulo.getTemporada().getId() : null)
                .imagenes(imagenes)
                .build();
    }
}