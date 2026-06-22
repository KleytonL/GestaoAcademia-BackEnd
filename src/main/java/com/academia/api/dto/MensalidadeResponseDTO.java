package com.academia.api.dto;

import com.academia.api.model.StatusMensalidade;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MensalidadeResponseDTO {

    private Long id;
    private Long alunoId;
    private String nomeAluno;
    private String mesAno;
    private Double valor;
    private StatusMensalidade status;
    private LocalDate dataPagamento;

}
