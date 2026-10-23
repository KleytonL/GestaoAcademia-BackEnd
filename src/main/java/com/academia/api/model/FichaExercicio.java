package com.academia.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "ficha_exercicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FichaExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Positive(message = "As séries devem ser maiores que zero")
    private int series;

    @Column(nullable = false)
    @Positive(message = "As repetições devem ser maiores que zero")
    private int repeticoes;

    @Column(nullable = false)
    @PositiveOrZero(message = "A carga não pode ser negativa")
    private int carga;

    @Column(nullable = false)
    @PositiveOrZero(message = "O descanso não pode ser negativo")
    private int descanso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ficha_id", nullable = false)
    private Ficha ficha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;
}