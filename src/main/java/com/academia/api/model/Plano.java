package com.academia.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "plano")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 50, message = "O campo deve conter no máximo 50 caracteres")
    private String nome;

    @Column(nullable = false)
    @Positive(message = "O valor deve ser maior que zero")
    private double valor;

    @Column(nullable = false)
    @Positive(message = "A duração deve ser maior que zero dias")
    @Max(value = 730, message = "A duração não pode ser maior que 730 dias / 2 anos")
    private int duracao;

    @Size(max = 255, message = "O campo deve conter no máximo 255 caracteres")
    private String descricao;

    @Column(nullable = false)
    @Builder .Default
    private boolean ativo = true;
}
