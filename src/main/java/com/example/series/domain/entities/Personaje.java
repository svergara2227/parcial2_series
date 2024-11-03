// src/main/java/com/example/series/domain/entities/Personaje.java
package com.example.series.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String foto;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor; // Actor que interpreta al personaje
}