package com.academia.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cpf;

    private LocalDate dataNascimento;
}
