package com.example.series.controllers;

import com.example.series.mapping.dtos.PersonajeDTO;
import com.example.series.services.personajes.PersonajeService;
import com.example.series.services.personajes.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired private PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDTO> crearPersonaje(@RequestBody PersonajeDTO personajeDTO) {
        return ResponseEntity.ok(personajeService.crearPersonaje(personajeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> obtenerPersonaje(@PathVariable Long id) {
        return ResponseEntity.ok(personajeService.obtenerPersonaje(id));
    }
}