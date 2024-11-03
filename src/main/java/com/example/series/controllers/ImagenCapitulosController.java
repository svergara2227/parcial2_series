package com.example.series.controllers;

import com.example.series.mapping.dtos.ImagenCapituloDTO;
import com.example.series.services.imagencapitulos.ImagenCapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes-capitulos")
public class ImagenCapitulosController {

    @Autowired
    private ImagenCapituloService imagenCapituloService;

    @PostMapping
    public ResponseEntity<ImagenCapituloDTO> crearImagenCapitulo(@RequestBody ImagenCapituloDTO imagenCapituloDTO) {
        return new ResponseEntity<>(imagenCapituloService.crearImagenCapitulo(imagenCapituloDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenCapituloDTO> obtenerImagenCapitulo(@PathVariable Long id) {
        return ResponseEntity.ok(imagenCapituloService.obtenerImagenCapitulo(id));
    }

    @GetMapping
    public ResponseEntity<List<ImagenCapituloDTO>> listarImagenesCapitulo() {
        return ResponseEntity.ok(imagenCapituloService.listarImagenesCapitulo());
    }

    @GetMapping("/capitulo/{capituloId}")
    public ResponseEntity<List<ImagenCapituloDTO>> listarImagenesPorCapitulo(@PathVariable Long capituloId) {
        return ResponseEntity.ok(imagenCapituloService.listarImagenesPorCapitulo(capituloId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenCapituloDTO> actualizarImagenCapitulo(
            @PathVariable Long id,
            @RequestBody ImagenCapituloDTO imagenCapituloDTO) {
        return ResponseEntity.ok(imagenCapituloService.actualizarImagenCapitulo(id, imagenCapituloDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarImagenCapitulo(@PathVariable Long id) {
        imagenCapituloService.eliminarImagenCapitulo(id);
        return ResponseEntity.noContent().build();
    }
}