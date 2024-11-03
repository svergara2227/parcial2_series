package com.example.series.services.temporadas;

import com.example.series.domain.entities.Serie;
import com.example.series.domain.entities.Temporada;
import com.example.series.mapping.dtos.TemporadaDTO;
import com.example.series.mapping.mappers.TemporadaMapper;
import com.example.series.repositories.series.SerieRepository;
import com.example.series.repositories.temporadas.TemporadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TemporadaServiceImpl implements TemporadaService {

    @Autowired private TemporadaRepository temporadaRepository;
    @Autowired private SerieRepository serieRepository;


    @Transactional
    public TemporadaDTO crearTemporada(TemporadaDTO temporadaDTO) {
        Serie serie = serieRepository.findById(temporadaDTO.serieId())
                .orElseThrow(() -> new RuntimeException("Serie no encontrada"));

        Temporada temporada = TemporadaMapper.mapFromDto(temporadaDTO);
        temporada.setSerie(serie);

        if(serie.getTemporadas() != null) {
            serie.setTemporadas(new ArrayList<>());
        }
        serie.getTemporadas().add(temporada);
        return TemporadaMapper.mapFromModel(temporadaRepository.save(temporada));
    }

    public TemporadaDTO obtenerTemporada(Long id) {
        return TemporadaMapper.mapFromModel(
                temporadaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Temporada no encontrada"))
        );
    }
}
