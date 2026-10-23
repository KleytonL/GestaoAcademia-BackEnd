package com.academia.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class FichaRequestDTO {
    private String nome;
    private String descricao;
    private Long usuarioId;
    private List<FichaExercicioRequestDTO> exercicios;
}