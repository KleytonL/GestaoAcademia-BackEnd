package com.academia.api.dto;

import lombok.Data;

@Data
public class ExercicioResponseDTO {
    private Long id;
    private String nome;
    private String grupo;
    private String descricao;
}
