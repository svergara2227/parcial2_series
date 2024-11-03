package com.example.series.services.series;

import com.example.series.domain.entities.Serie;
import com.example.series.mapping.dtos.SerieDTO;
import com.example.series.mapping.mappers.ImagenCapituloMapper;
import com.example.series.mapping.mappers.PersonajeMapper;
import com.example.series.mapping.mappers.SerieMapper;
import com.example.series.repositories.series.SerieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SerieServiceImpl implements SerieService {


    @Autowired
    private SerieRepository serieRepository;


    @Transactional
    public SerieDTO crearSerie(SerieDTO serieDTO) {
        return SerieMapper.mapFromModel(serieRepository.save(SerieMapper.mapFromDto(serieDTO)));
    }

    public SerieDTO obtenerSerie(Long id) {
        return SerieMapper.mapFromModel(serieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personaje no encontrado")));
    }
}
