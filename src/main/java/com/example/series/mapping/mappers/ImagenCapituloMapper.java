package com.example.series.mapping.mappers;

import com.example.series.domain.entities.ImagenCapitulo;
import com.example.series.mapping.dtos.ImagenCapituloDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ImagenCapituloMapper {

    // Convertir de Entity a DTO
    public static ImagenCapituloDTO mapFromModel(ImagenCapitulo imagenCapitulo) {
        return new ImagenCapituloDTO(
                imagenCapitulo.getId(),
                imagenCapitulo.getUrl(),
                imagenCapitulo.getCapitulo() != null ? imagenCapitulo.getCapitulo().getId() : null
        );
    }

    // Convertir de DTO a Entity
    public static ImagenCapitulo mapFromDto(ImagenCapituloDTO dto) {
        return ImagenCapitulo.builder()
                .id(dto.id())
                .url(dto.url())
                .build();
        // Nota: el Capitulo se debe establecer después, ya que necesita ser
        // recuperado de la base de datos
    }

    // Método para convertir una lista de entities a DTOs
    public static List<ImagenCapituloDTO> mapFromModelList(List<ImagenCapitulo> imagenes) {
        return imagenes.stream()
                .map(ImagenCapituloMapper::mapFromModel)
                .collect(Collectors.toList());
    }

    // Método para convertir una lista de DTOs a entities
    public static List<ImagenCapitulo> mapFromDtoList(List<ImagenCapituloDTO> dtos) {
        return dtos.stream()
                .map(ImagenCapituloMapper::mapFromDto)
                .collect(Collectors.toList());
    }
}