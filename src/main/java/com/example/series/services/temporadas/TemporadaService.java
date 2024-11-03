package com.example.series.services.temporadas;

import com.example.series.mapping.dtos.TemporadaDTO;

import java.util.List;

public interface TemporadaService {

        TemporadaDTO crearTemporada(TemporadaDTO temporadaDTO);

        TemporadaDTO obtenerTemporada(Long id);
}
