package com.example.series.controllers;

import com.example.series.mapping.dtos.ActorDTO;
import com.example.series.services.actores.ActorService;
import com.example.series.services.actores.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actores")
public class ActorController {

    @Autowired private ActorService actorService;

    @PostMapping
    public ResponseEntity<ActorDTO> crearActor(@RequestBody ActorDTO actorDTO) {
        return ResponseEntity.ok(actorService.crearActor(actorDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> obtenerActor(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.obtenerActor(id));
    }
}