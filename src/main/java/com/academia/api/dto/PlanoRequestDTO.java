package com.academia.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PlanoRequestDTO {

    @NotBlank
    private String nome;

    @Positive
    private double valor;

    @Positive
    private int duracao;

    private String descricao;
}
