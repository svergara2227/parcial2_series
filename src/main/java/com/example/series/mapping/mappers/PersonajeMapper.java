// src/main/java/com/example/series/mapping/mappers/PersonajeMapper.java
package com.example.series.mapping.mappers;

import com.example.series.domain.entities.Actor;
import com.example.series.domain.entities.Personaje;
import com.example.series.domain.entities.Serie;
import com.example.series.mapping.dtos.PersonajeDTO;

public class PersonajeMapper {
    public static Personaje mapFromDto(PersonajeDTO personajeDTO) {
        if (personajeDTO == null) {
            return null;
        }

        return Personaje.builder()
                .id(personajeDTO.id())
                .nombre(personajeDTO.nombre())
                .descripcion(personajeDTO.descripcion())
                .foto(personajeDTO.foto())
                .serie(personajeDTO.serieId() != null ?
                        Serie.builder().id(personajeDTO.serieId()).build() : null)
                .actor(personajeDTO.actorId() != null ?
                        Actor.builder().id(personajeDTO.actorId()).build() : null)
                .build();
    }

    public static PersonajeDTO mapFromModel(Personaje personaje) {
        if (personaje == null) {
            return null;
        }

        return PersonajeDTO.builder()
                .id(personaje.getId())
                .nombre(personaje.getNombre())
                .descripcion(personaje.getDescripcion())
                .foto(personaje.getFoto())
                .serieId(personaje.getSerie() != null ?
                        personaje.getSerie().getId() : null)
                .actorId(personaje.getActor() != null ?
                        personaje.getActor().getId() : null)
                .build();
    }
}