package com.academia.api.dto;

import lombok.Data;

@Data
public class FichaExercicioResponseDTO {
    private Long id;
    private Long exercicioId;
    private String exercicioNome;
    private String exercicioGrupo;
    private int series;
    private int repeticoes;
    private int carga;
    private int descanso;
}