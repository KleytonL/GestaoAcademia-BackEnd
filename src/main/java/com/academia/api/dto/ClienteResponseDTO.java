package com.academia.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
}
