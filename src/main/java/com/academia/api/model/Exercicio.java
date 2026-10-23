package com.academia.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "exercicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O campo deve conter no máximo 100 caracteres")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "O grupo é obrigatório")
    @Size(max = 50, message = "O campo deve conter no máximo 50 caracteres")
    private String grupo;

    @Size(max = 255, message = "O campo deve conter no máximo 255 caracteres")
    private String descricao;
}