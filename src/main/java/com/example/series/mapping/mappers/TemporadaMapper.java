// src/main/java/com/example/series/mapping/mappers/TemporadaMapper.java
package com.example.series.mapping.mappers;

import com.example.series.domain.entities.Capitulo;
import com.example.series.domain.entities.Temporada;
import com.example.series.mapping.dtos.CapituloDTO;
import com.example.series.mapping.dtos.TemporadaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TemporadaMapper {
    public static Temporada mapFromDto(TemporadaDTO temporadaDTO) {
        return Temporada.builder()
                .id(temporadaDTO.id())
                .numeroTemporada(temporadaDTO.numeroTemporada())
                .anioLanzamiento(temporadaDTO.anioLanzamiento())
                .capitulos(mapCapitulosFromDto(temporadaDTO.capitulos())) // Mapea la lista de DTOs de Capítulo
                .build();
    }

    public static TemporadaDTO mapFromModel(Temporada temporada) {
        return TemporadaDTO.builder()
                .id(temporada.getId())
                .numeroTemporada(temporada.getNumeroTemporada())
                .anioLanzamiento(temporada.getAnioLanzamiento())
                .serieId(temporada.getSerie().getId())
                .capitulos(mapCapitulosFromModel(temporada.getCapitulos())) // Mapea la lista de entidades de Capítulo
                .build();
    }

    private static List<CapituloDTO> mapCapitulosFromModel(List<Capitulo> capitulos) {
        return capitulos.stream()
                .map(CapituloMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    private static List<Capitulo> mapCapitulosFromDto(List<CapituloDTO> capitulosDTO) {
        return capitulosDTO.stream()
                .map(CapituloMapper::mapFromDto)
                .collect(Collectors.toList());
    }
}
