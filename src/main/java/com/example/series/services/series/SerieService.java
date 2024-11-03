package com.example.series.services.series;

import com.example.series.mapping.dtos.SerieDTO;

import java.util.List;

public interface SerieService {

    SerieDTO crearSerie(SerieDTO serieDTO);

    SerieDTO obtenerSerie(Long id);

}
