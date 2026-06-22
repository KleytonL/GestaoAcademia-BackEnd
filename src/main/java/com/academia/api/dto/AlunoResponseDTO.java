package com.academia.api.dto;

import com.academia.api.model.StatusMensalidade;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private StatusMensalidade status;

}
