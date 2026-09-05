package com.academia.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlanoRequestDTO {

    @NotBlank
    @Size(max = 50, message = "O campo deve conter no máximo 50 caracteres")
    private String nome;

    @Positive(message = "O valor deve ser maior que zero")
    private double valor;

    @Positive(message = "A duração deve ser maior que zero dias")
    @Max(value = 730, message = "A duração não pode ser maior que 730 dias / 2 anos")
    private int duracao;

    @Size(max = 255, message = "O campo deve conter no máximo 255 caracteres")
    private String descricao;
}
