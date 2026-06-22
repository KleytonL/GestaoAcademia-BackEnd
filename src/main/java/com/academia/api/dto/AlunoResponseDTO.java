package com.academia.api.dto;

import com.academia.api.model.PlanoAluno;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    private PlanoAluno plano;

}
