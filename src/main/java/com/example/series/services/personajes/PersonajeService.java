package com.example.series.services.personajes;

import com.example.series.mapping.dtos.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

        PersonajeDTO obtenerPersonaje(Long id);

        PersonajeDTO crearPersonaje(PersonajeDTO personajeDTO);
}
