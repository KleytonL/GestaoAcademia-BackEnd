package com.academia.api.service;

import com.academia.api.dto.MensalidadeResponseDTO;
import com.academia.api.model.Mensalidade;
import com.academia.api.repository.MensalidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MensalidadeService {

    private final MensalidadeRepository mensalidadeRepository;

    public List<MensalidadeResponseDTO> listarPorAluno(Long alunoId){
        return mensalidadeRepository.findByAlunoId(alunoId).stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public MensalidadeResponseDTO toResponseDTO(Mensalidade mensalidade){
        MensalidadeResponseDTO dto = new MensalidadeResponseDTO();

        dto.setId(mensalidade.getId());
        dto.setAlunoId(mensalidade.getAluno().getId());
        dto.setDataPagamento(mensalidade.getDataPagamento());
        dto.setMesAno(mensalidade.getMesAno());
        dto.setValor(mensalidade.getValor());
        dto.setStatus(mensalidade.getStatus());
        dto.setDataPagamento(mensalidade.getDataPagamento());

        return dto;
    }
}
