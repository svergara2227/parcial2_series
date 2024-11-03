package com.example.series.controllers;

import com.example.series.mapping.dtos.CapituloDTO;
import com.example.series.services.capitulos.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capitulos")
public class CapituloController {

    @Autowired private CapituloService capituloService;

    @PostMapping
    public ResponseEntity<CapituloDTO> crearCapitulo(@RequestBody CapituloDTO capituloDTO) {
        return ResponseEntity.ok(capituloService.crearCapitulo(capituloDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapituloDTO> obtenerCapitulo(@PathVariable Long id) {
        return ResponseEntity.ok(capituloService.obtenerCapitulo(id));
    }
}