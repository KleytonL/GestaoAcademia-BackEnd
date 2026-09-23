package com.academia.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    @Size(max = 25, message = "O campo deve conter no máximo 25 caracteres")
    @Pattern(regexp = "^[\\p{L}\s]+$", message = "Não pode conter números ou símbolos")
    private String nome;

    @NotBlank
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}\\-\\d{4}$", message = "Número de telefone inválido")
    private String telefone;

    @NotBlank
    @CPF(message = "CPF inválido")
    private String cpf;

    @Past(message = "Data de nascimento não pode passar do dia atual")
    private LocalDate dataNascimento;
}
