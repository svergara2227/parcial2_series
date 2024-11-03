package com.example.series.services.actores;

import com.example.series.domain.entities.Actor;
import com.example.series.mapping.dtos.ActorDTO;

import java.util.List;

public interface ActorService {

            ActorDTO obtenerActor(Long id);

            ActorDTO crearActor(ActorDTO actorDTO);
}
