package com.example.series.controllers;

import com.example.series.mapping.dtos.TemporadaDTO;
import com.example.series.services.temporadas.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temporadas")
public class TemporadaController {

    @Autowired private TemporadaService temporadaService;

    @PostMapping
    public ResponseEntity<TemporadaDTO> crearTemporada(@RequestBody TemporadaDTO temporadaDTO) {
        return ResponseEntity.ok(temporadaService.crearTemporada(temporadaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemporadaDTO> obtenerTemporada(@PathVariable Long id) {
        return ResponseEntity.ok(temporadaService.obtenerTemporada(id));
    }
}