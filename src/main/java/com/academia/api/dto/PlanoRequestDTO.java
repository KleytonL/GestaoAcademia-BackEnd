package com.academia.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlanoRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private double valor;

    @NotBlank
    private int duracao;

    private String descricao;
}
