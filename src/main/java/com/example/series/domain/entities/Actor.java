// src/main/java/com/example/series/domain/entities/Actor.java
package com.example.series.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String biografia;
    private String foto;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<Personaje> personajes; // Personajes interpretados por el actor

    @ManyToMany(mappedBy = "actores")
    private List<Serie> series; // Series en las que participa el actor
}