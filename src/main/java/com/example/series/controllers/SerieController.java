package com.example.series.controllers;

import com.example.series.mapping.dtos.SerieDTO;
import com.example.series.services.series.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired private SerieService serieService;

    @PostMapping
    public ResponseEntity<SerieDTO> crearSerie(@RequestBody SerieDTO serieDTO) {
        return ResponseEntity.ok(serieService.crearSerie(serieDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieDTO> obtenerSerie(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.obtenerSerie(id));
    }
}