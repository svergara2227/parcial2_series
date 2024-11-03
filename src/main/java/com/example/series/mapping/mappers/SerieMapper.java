// src/main/java/com/example/series/mapping/mappers/SerieMapper.java
package com.example.series.mapping.mappers;

import com.example.series.domain.entities.Actor;
import com.example.series.domain.entities.Personaje;
import com.example.series.domain.entities.Serie;
import com.example.series.domain.entities.Temporada;
import com.example.series.mapping.dtos.ActorDTO;
import com.example.series.mapping.dtos.PersonajeDTO;
import com.example.series.mapping.dtos.SerieDTO;
import com.example.series.mapping.dtos.TemporadaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SerieMapper {
    public static Serie mapFromDto(SerieDTO serieDTO) {
        return Serie.builder()
                .id(serieDTO.id())
                .nombre(serieDTO.nombre())
                .descripcion(serieDTO.descripcion())
                .creador(serieDTO.creador())
                .clasificacion(serieDTO.clasificacion())
                .numeroTemporadas(serieDTO.numeroTemporadas())
                .anioEmision(serieDTO.anioEmision())
                .imagenPoster(serieDTO.imagenPoster())
                .temporadas(mapTemporadasFromDto(serieDTO.temporadas())) // Mapea la lista de DTOs de Temporada
                .personajes(mapPersonajesFromDto(serieDTO.personajes())) // Mapea la lista de DTOs de Personaje
                .actores(mapActoresFromDto(serieDTO.actores())) // Mapea la lista de DTOs de Actor
                .build();
    }

    public static SerieDTO mapFromModel(Serie serie) {
        return SerieDTO.builder()
                .id(serie.getId())
                .nombre(serie.getNombre())
                .descripcion(serie.getDescripcion())
                .creador(serie.getCreador())
                .clasificacion(serie.getClasificacion())
                .numeroTemporadas(serie.getNumeroTemporadas())
                .anioEmision(serie.getAnioEmision())
                .imagenPoster(serie.getImagenPoster())
                .temporadas(mapTemporadasFromModel(serie.getTemporadas())) // Mapea la lista de entidades de Temporada
                .personajes(mapPersonajesFromModel(serie.getPersonajes())) // Mapea la lista de entidades de Personaje
                .actores(mapActoresFromModel(serie.getActores())) // Mapea la lista de entidades de Actor
                .build();
    }

    private static List<TemporadaDTO> mapTemporadasFromModel(List<Temporada> temporadas) {
        return temporadas.stream()
                .map(TemporadaMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    private static List<Temporada> mapTemporadasFromDto(List<TemporadaDTO> temporadasDTO) {
        return temporadasDTO.stream()
                .map(TemporadaMapper::mapFromDto)
                .collect(Collectors.toList());
    }

    private static List<PersonajeDTO> mapPersonajesFromModel(List<Personaje> personajes) {
        return personajes.stream()
                .map(PersonajeMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    private static List<Personaje> mapPersonajesFromDto(List<PersonajeDTO> personajesDTO) {
        return personajesDTO.stream()
                .map(PersonajeMapper::mapFromDto)
                .collect(Collectors.toList());
    }

    private static List<ActorDTO> mapActoresFromModel(List<Actor> actores) {
        return actores.stream()
                .map(ActorMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    private static List<Actor> mapActoresFromDto(List<ActorDTO> actoresDTO) {
        return actoresDTO.stream()
                .map(ActorMapper::mapFromDto)
                .collect(Collectors.toList());
    }
}
