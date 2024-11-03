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
public class Temporada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroTemporada;
    private int anioLanzamiento;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL)
    private List<Capitulo> capitulos;


}

