package com.academia.api.service;

import com.academia.api.dto.ExercicioResponseDTO;
import com.academia.api.repository.ExercicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public List<ExercicioResponseDTO> listarTodos() {
        return exercicioRepository.findAllByOrderByNomeAsc().stream().map(e -> {
            ExercicioResponseDTO dto = new ExercicioResponseDTO();
            dto.setId(e.getId());
            dto.setNome(e.getNome());
            dto.setGrupo(e.getGrupo());
            dto.setDescricao(e.getDescricao());
            return dto;
        }).collect(Collectors.toList());
    }
}
