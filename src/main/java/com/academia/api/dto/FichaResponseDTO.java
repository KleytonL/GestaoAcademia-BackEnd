package com.academia.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FichaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private Long usuarioId;
    private String usuarioNome;
    private List<FichaExercicioResponseDTO> exercicios;
}
