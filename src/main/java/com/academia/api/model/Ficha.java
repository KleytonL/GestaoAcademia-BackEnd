package com.academia.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "ficha")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O nome da ficha é obrigatório")
    @Size(max = 50, message = "O campo deve conter no máximo 50 caracteres")
    private String nome;

    @Size(max = 255, message = "O campo deve conter no máximo 255 caracteres")
    private String descricao;

    @Column(name = "data_criacao", nullable = false)
    @Builder.Default
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "O usuário é obrigatório")
    private Usuario usuario;

    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<FichaExercicio> exercicios = new ArrayList<>();
}