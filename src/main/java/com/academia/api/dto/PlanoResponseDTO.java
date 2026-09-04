package com.academia.api.dto;

import lombok.Data;

@Data
public class PlanoResponseDTO {

    private Long id;
    private String nome;
    private double valor;
    private int duracao;
    private String descricao;
    private boolean ativo;

}
