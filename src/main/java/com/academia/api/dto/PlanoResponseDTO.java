package com.academia.api.dto;

import com.academia.api.model.StatusPagamento;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanoResponseDTO {

    private Long id;
    private Long alunoId;
    private String nomeAluno;
    private String mesAno;
    private Double valor;
    private StatusPagamento status;
    private LocalDate dataPagamento;

}
