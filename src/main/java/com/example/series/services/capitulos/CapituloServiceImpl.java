package com.example.series.services.capitulos;


import com.example.series.domain.entities.Capitulo;
import com.example.series.domain.entities.ImagenCapitulo;
import com.example.series.domain.entities.Temporada;
import com.example.series.mapping.dtos.CapituloDTO;
import com.example.series.mapping.mappers.ActorMapper;
import com.example.series.mapping.mappers.CapituloMapper;
import com.example.series.repositories.capitulos.CapituloRepository;
import com.example.series.repositories.imagencapitulos.ImagenCapituloRepository;
import com.example.series.repositories.temporadas.TemporadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapituloServiceImpl implements CapituloService {

    @Autowired private CapituloRepository capituloRepository;
    @Autowired private TemporadaRepository temporadaRepository;
    @Autowired private ImagenCapituloRepository imagenCapituloRepository;


    @Transactional
    public CapituloDTO crearCapitulo(CapituloDTO capituloDTO) {
        Temporada temporada = temporadaRepository.findById(capituloDTO.temporadaId())
                .orElseThrow(() -> new RuntimeException("Temporada no encontrada"));

        Capitulo capitulo = CapituloMapper.mapFromDto(capituloDTO);
        capitulo.setTemporada(temporada);

        Capitulo capituloGuardado = capituloRepository.save(capitulo);

        // Guardar imágenes del capítulo
        if (capituloDTO.imagenes() != null) {
            capituloDTO.imagenes().forEach(imagenDTO -> {
                ImagenCapitulo imagen = new ImagenCapitulo();
                imagen.setUrl(imagenDTO.url());
                imagen.setCapitulo(capituloGuardado);
                imagenCapituloRepository.save(imagen);
            });
        }

        return CapituloMapper.mapFromModel(capituloGuardado);
    }

    public CapituloDTO obtenerCapitulo(Long id) {
        return CapituloMapper.mapFromModel(
                capituloRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Capítulo no encontrado"))
        );
    }
}
