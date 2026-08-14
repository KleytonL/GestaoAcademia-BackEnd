package com.academia.api.service;

import com.academia.api.dto.PlanoResponseDTO;
import com.academia.api.model.Plano;
import com.academia.api.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoRepository planoRepository;

    public List<PlanoResponseDTO> listarPorAluno(Long alunoId){
        return planoRepository.findByAlunoId(alunoId).stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public PlanoResponseDTO toResponseDTO(Plano plano){
        PlanoResponseDTO dto = new PlanoResponseDTO();

//        dto.setId(plano.getId());
//        dto.setAlunoId(plano.getAluno().getId());
//        dto.setDataPagamento(plano.getDataPagamento());
//        dto.setMesAno(plano.getMesAno());
//        dto.setValor(plano.getValor());
//        dto.setStatus(plano.getStatus());
//        dto.setDataPagamento(plano.getDataPagamento());

        return dto;
    }
}
