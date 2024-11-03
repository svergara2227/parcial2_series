package com.example.series.services.actores;

import com.example.series.domain.entities.Actor;
import com.example.series.mapping.dtos.ActorDTO;
import com.example.series.mapping.mappers.ActorMapper;
import com.example.series.repositories.actores.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;



    @Override
    public ActorDTO obtenerActor(Long id) {
        return ActorMapper.mapFromModel(actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado")));
    }


    @Override
    public ActorDTO crearActor(ActorDTO actorDTO) {
        return ActorMapper.mapFromModel(actorRepository.save(ActorMapper.mapFromDto(actorDTO)));
    }


}