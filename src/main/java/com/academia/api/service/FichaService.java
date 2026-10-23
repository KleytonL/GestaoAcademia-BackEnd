package com.academia.api.service;

import com.academia.api.dto.FichaExercicioRequestDTO;
import com.academia.api.dto.FichaExercicioResponseDTO;
import com.academia.api.dto.FichaRequestDTO;
import com.academia.api.dto.FichaResponseDTO;
import com.academia.api.model.Exercicio;
import com.academia.api.model.Ficha;
import com.academia.api.model.FichaExercicio;
import com.academia.api.model.Usuario;
import com.academia.api.repository.ExercicioRepository;
import com.academia.api.repository.FichaRepository;
import com.academia.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FichaService {

    private final FichaRepository fichaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ExercicioRepository exercicioRepository;

    public List<FichaResponseDTO> listarTodos(Long usuarioId) {
        List<Ficha> fichas = (usuarioId != null)
                ? fichaRepository.findByUsuarioId(usuarioId)
                : fichaRepository.findAll();

        return fichas.stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public FichaResponseDTO buscarPorId(Long id) {
        return toResponseDTO(buscarFicha(id));
    }

    @Transactional
    public FichaResponseDTO cadastrarFicha(FichaRequestDTO dto) {
        Usuario usuario = null;
        if (dto.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        }

        Ficha ficha = Ficha.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .usuario(usuario)
                .build();

        preencherExercicios(ficha, dto.getExercicios());

        return toResponseDTO(fichaRepository.save(ficha));
    }

    @Transactional
    public FichaResponseDTO atualizarFicha(Long id, FichaRequestDTO dto) {
        Ficha ficha = buscarFicha(id);

        ficha.setNome(dto.getNome());
        ficha.setDescricao(dto.getDescricao());

        ficha.getExercicios().clear();
        preencherExercicios(ficha, dto.getExercicios());

        return toResponseDTO(fichaRepository.save(ficha));
    }

    @Transactional
    public void deletarFicha(Long id) {
        fichaRepository.delete(buscarFicha(id));
    }

    private Ficha buscarFicha(Long id) {
        return fichaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ficha não encontrada!"));
    }

    private void preencherExercicios(Ficha ficha, List<FichaExercicioRequestDTO> itens) {
        if (itens == null) return;

        for (FichaExercicioRequestDTO item : itens) {
            Exercicio exercicio = exercicioRepository.findById(item.getExercicioId())
                    .orElseThrow(() -> new RuntimeException("Exercício não encontrado!"));

            ficha.getExercicios().add(FichaExercicio.builder()
                    .ficha(ficha)
                    .exercicio(exercicio)
                    .series(item.getSeries())
                    .repeticoes(item.getRepeticoes())
                    .carga(item.getCarga())
                    .descanso(item.getDescanso())
                    .build());
        }
    }

    private FichaResponseDTO toResponseDTO(Ficha ficha) {
        FichaResponseDTO dto = new FichaResponseDTO();
        dto.setId(ficha.getId());
        dto.setNome(ficha.getNome());
        dto.setDescricao(ficha.getDescricao());
        dto.setDataCriacao(ficha.getDataCriacao());
        dto.setUsuarioId(ficha.getUsuario().getId());
        dto.setUsuarioNome(ficha.getUsuario().getNome());

        dto.setExercicios(ficha.getExercicios().stream().map(fe -> {
            FichaExercicioResponseDTO item = new FichaExercicioResponseDTO();
            item.setId(fe.getId());
            item.setExercicioId(fe.getExercicio().getId());
            item.setExercicioNome(fe.getExercicio().getNome());
            item.setExercicioGrupo(fe.getExercicio().getGrupo());
            item.setSeries(fe.getSeries());
            item.setRepeticoes(fe.getRepeticoes());
            item.setCarga(fe.getCarga());
            item.setDescanso(fe.getDescanso());
            return item;
        }).collect(Collectors.toList()));

        return dto;
    }
}