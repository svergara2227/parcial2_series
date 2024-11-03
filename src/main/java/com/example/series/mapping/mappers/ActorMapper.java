// src/main/java/com/example/series/mapping/mappers/ActorMapper.java
package com.example.series.mapping.mappers;

import com.example.series.domain.entities.Actor;
import com.example.series.domain.entities.Personaje;
import com.example.series.domain.entities.Serie;
import com.example.series.mapping.dtos.ActorDTO;
import com.example.series.mapping.dtos.PersonajeDTO;
import com.example.series.mapping.dtos.SerieDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ActorMapper {
    public static Actor mapFromDto(ActorDTO actorDTO) {
        List<Personaje> personajes = actorDTO.personajes()
                .stream()
                .map(PersonajeMapper::mapFromDto) // Mapea cada PersonajeDTO a Personaje
                .collect(Collectors.toList());

        List<Serie> series = actorDTO.series()
                .stream()
                .map(SerieMapper::mapFromDto) // Mapea cada SerieDTO a Serie
                .collect(Collectors.toList());

        return Actor.builder()
                .id(actorDTO.id())
                .nombre(actorDTO.nombre())
                .biografia(actorDTO.biografia())
                .foto(actorDTO.foto())
                .personajes(personajes) // Asignar la lista de personajes convertida
                .series(series) // Asignar la lista de series convertida
                .build();
    }

    public static ActorDTO mapFromModel(Actor actor) {
        List<PersonajeDTO> personajes = actor.getPersonajes()
                .stream()
                .map(PersonajeMapper::mapFromModel) // Mapea cada Personaje a PersonajeDTO
                .collect(Collectors.toList());

        List<SerieDTO> series = actor.getSeries()
                .stream()
                .map(SerieMapper::mapFromModel) // Mapea cada Serie a SerieDTO
                .collect(Collectors.toList());

        return ActorDTO.builder()
                .id(actor.getId())
                .nombre(actor.getNombre())
                .biografia(actor.getBiografia())
                .foto(actor.getFoto())
                .personajes(personajes) // Asignar la lista de personajes convertida
                .series(series) // Asignar la lista de series convertida
                .build();
    }
}
