
package com.example.series.services.imagencapitulos;
import com.example.series.domain.entities.Capitulo;
import com.example.series.domain.entities.ImagenCapitulo;
import com.example.series.mapping.dtos.ImagenCapituloDTO;
import com.example.series.mapping.mappers.ImagenCapituloMapper;
import com.example.series.repositories.capitulos.CapituloRepository;
import com.example.series.repositories.imagencapitulos.ImagenCapituloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenCapituloServiceImpl implements ImagenCapituloService {

    @Autowired
    private ImagenCapituloRepository imagenCapituloRepository;

    @Autowired
    private CapituloRepository capituloRepository;

    @Override
    @Transactional
    public ImagenCapituloDTO crearImagenCapitulo(ImagenCapituloDTO imagenCapituloDTO) {
        Capitulo capitulo = capituloRepository.findById(imagenCapituloDTO.capituloId())
                .orElseThrow(() -> new RuntimeException("Capítulo no encontrado"));

        ImagenCapitulo imagenCapitulo = ImagenCapituloMapper.mapFromDto(imagenCapituloDTO);
        imagenCapitulo.setCapitulo(capitulo);

        return ImagenCapituloMapper.mapFromModel(imagenCapituloRepository.save(imagenCapitulo));
    }

    @Override
    public ImagenCapituloDTO obtenerImagenCapitulo(Long id) {
        return ImagenCapituloMapper.mapFromModel(
                imagenCapituloRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Imagen de capítulo no encontrada"))
        );
    }

    @Override
    public List<ImagenCapituloDTO> listarImagenesCapitulo() {
        return ImagenCapituloMapper.mapFromModelList(imagenCapituloRepository.findAll());
    }

    @Override
    public List<ImagenCapituloDTO> listarImagenesPorCapitulo(Long capituloId) {
        return ImagenCapituloMapper.mapFromModelList(
                imagenCapituloRepository.findByCapituloId(capituloId)
        );
    }

    @Override
    @Transactional
    public ImagenCapituloDTO actualizarImagenCapitulo(Long id, ImagenCapituloDTO imagenCapituloDTO) {
        ImagenCapitulo imagenExistente = imagenCapituloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen de capítulo no encontrada"));

        // Si se está cambiando el capítulo, buscar el nuevo
        if (!imagenExistente.getCapitulo().getId().equals(imagenCapituloDTO.capituloId())) {
            Capitulo nuevoCapitulo = capituloRepository.findById(imagenCapituloDTO.capituloId())
                    .orElseThrow(() -> new RuntimeException("Capítulo no encontrado"));
            imagenExistente.setCapitulo(nuevoCapitulo);
        }

        imagenExistente.setUrl(imagenCapituloDTO.url());

        return ImagenCapituloMapper.mapFromModel(imagenCapituloRepository.save(imagenExistente));
    }

    @Override
    @Transactional
    public void eliminarImagenCapitulo(Long id) {
        if (!imagenCapituloRepository.existsById(id)) {
            throw new RuntimeException("Imagen de capítulo no encontrada");
        }
        imagenCapituloRepository.deleteById(id);
    }
}