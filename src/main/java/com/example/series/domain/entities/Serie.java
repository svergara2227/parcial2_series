// src/main/java/com/example/series/domain/entities/Serie.java
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
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String creador;
    private String clasificacion;
    private int numeroTemporadas;
    private int anioEmision;
    private String imagenPoster;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Temporada> temporadas;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Personaje> personajes; // Personajes de la serie

    @ManyToMany
    @JoinTable(
            name = "serie_actor",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actores; // Actores que participan en la serie
}