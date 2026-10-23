package com.academia.api.dto;

import lombok.Data;

@Data
public class FichaExercicioRequestDTO {
    private Long exercicioId;
    private int series;
    private int repeticoes;
    private int carga;
    private int descanso;
}
