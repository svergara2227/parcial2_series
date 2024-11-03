package com.example.series.services.personajes;

import com.example.series.domain.entities.Actor;
import com.example.series.domain.entities.Personaje;
import com.example.series.domain.entities.Serie;
import com.example.series.mapping.dtos.PersonajeDTO;
import com.example.series.mapping.mappers.PersonajeMapper;
import com.example.series.repositories.actores.ActorRepository;
import com.example.series.repositories.personajes.PersonajeRepository;
import com.example.series.repositories.series.SerieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private SerieRepository serieRepository;
    @Autowired
    private ActorRepository actorRepository;

    @Transactional
    public PersonajeDTO crearPersonaje(PersonajeDTO personajeDTO) {
        // Usar serieId en lugar de id
        Serie serie = serieRepository.findById(personajeDTO.serieId())
                .orElseThrow(() -> new RuntimeException("Serie no encontrada con ID: " + personajeDTO.serieId()));

        // Usar actorId en lugar de id
        Actor actor = actorRepository.findById(personajeDTO.actorId())
                .orElseThrow(() -> new RuntimeException("Actor no encontrado con ID: " + personajeDTO.actorId()));

        Personaje personaje = PersonajeMapper.mapFromDto(personajeDTO);
        personaje.setSerie(serie);
        personaje.setActor(actor);
        return PersonajeMapper.mapFromModel(personajeRepository.save(personaje));
    }

    public PersonajeDTO obtenerPersonaje(Long id) {
        return PersonajeMapper.mapFromModel(
                personajeRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Personaje no encontrado"))
        );
    }
}
