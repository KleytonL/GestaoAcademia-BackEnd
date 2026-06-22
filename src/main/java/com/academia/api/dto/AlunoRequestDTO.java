package com.academia.api.dto;

import com.academia.api.model.StatusMensalidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlunoRequestDTO {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    private LocalDate dataNascimento;

    private StatusMensalidade status;
}
