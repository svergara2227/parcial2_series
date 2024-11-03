package com.example.series.services.imagencapitulos;

import com.example.series.mapping.dtos.ImagenCapituloDTO;
import java.util.List;

public interface ImagenCapituloService {
    ImagenCapituloDTO crearImagenCapitulo(ImagenCapituloDTO imagenCapituloDTO);

    ImagenCapituloDTO obtenerImagenCapitulo(Long id);

    List<ImagenCapituloDTO> listarImagenesCapitulo();

    List<ImagenCapituloDTO> listarImagenesPorCapitulo(Long capituloId);

    ImagenCapituloDTO actualizarImagenCapitulo(Long id, ImagenCapituloDTO imagenCapituloDTO);

    void eliminarImagenCapitulo(Long id);
}