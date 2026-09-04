package com.academia.api.service;

import com.academia.api.dto.PlanoRequestDTO;
import com.academia.api.dto.PlanoResponseDTO;
import com.academia.api.model.Plano;
import com.academia.api.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoRepository planoRepository;

    public List<PlanoResponseDTO> listarTodos(@RequestParam(required = false) Boolean ativo){
        List<Plano> planos = (ativo != null)
                ? planoRepository.findByAtivo(ativo)
                : planoRepository.findAll();

        return planos.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public PlanoResponseDTO buscarPorId(@RequestParam Long id){
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado!"));
        return toResponseDTO(plano);
    }

    public PlanoResponseDTO cadastrarPlano(PlanoRequestDTO dto) {
        Plano plano = Plano.builder()
                .nome(dto.getNome())
                .valor(dto.getValor())
                .duracao(dto.getDuracao())
                .descricao(dto.getDescricao())
                .build();

        return  toResponseDTO(planoRepository.save(plano));
    }

    public PlanoResponseDTO atualizarPlano(Long id, PlanoRequestDTO dto) {
        Plano plano = planoRepository.findById(id).orElseThrow(() -> new RuntimeException("Plano não encontrado!"));

        plano.setNome(dto.getNome());
        plano.setValor(dto.getValor());
        plano.setDuracao(dto.getDuracao());
        plano.setDescricao(dto.getDescricao());

        return  toResponseDTO(planoRepository.save(plano));
    }

    public void deletarPlano(Long id){
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado!"));
        plano.setAtivo(false);
        planoRepository.save(plano);
    }

    public PlanoResponseDTO toResponseDTO(Plano plano){
        PlanoResponseDTO dto = new PlanoResponseDTO();

        dto.setId(plano.getId());
        dto.setValor(plano.getValor());
        dto.setDuracao(plano.getDuracao());
        dto.setDescricao(plano.getDescricao());

        return dto;
    }
}
