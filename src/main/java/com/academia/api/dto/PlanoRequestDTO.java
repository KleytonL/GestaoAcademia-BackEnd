package com.academia.api.dto;

import lombok.Data;

@Data
public class PlanoRequestDTO {
    private String nome;
    private double valor;
    private int duracao;
    private String descricao;
}
