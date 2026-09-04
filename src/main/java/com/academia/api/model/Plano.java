package com.academia.api.model;

import jakarta.persistence.*;
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
    private String nome;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int duracao;

    private String descricao;

    @Column(nullable = false)
    @Builder .Default
    private boolean ativo = true;
}
