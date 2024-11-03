// src/main/java/com/example/series/domain/entities/Capitulo.java
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
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroCapitulo;
    private String nombre;
    private String descripcion;
    private double calificacionPromedio;

    @ManyToOne
    @JoinColumn(name = "temporada_id")
    private Temporada temporada;

    @OneToMany(mappedBy = "capitulo", cascade = CascadeType.ALL)
    private List<ImagenCapitulo> imagenes;
}