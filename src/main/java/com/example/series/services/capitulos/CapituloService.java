package com.example.series.services.capitulos;

import com.example.series.mapping.dtos.CapituloDTO;

import java.util.List;

public interface CapituloService
{
    CapituloDTO crearCapitulo(CapituloDTO capituloDTO);

    CapituloDTO obtenerCapitulo(Long id);


}
