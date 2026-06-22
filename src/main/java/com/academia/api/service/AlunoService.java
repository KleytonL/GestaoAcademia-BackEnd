package com.academia.api.service;

import com.academia.api.dto.AlunoRequestDTO;
import com.academia.api.dto.AlunoResponseDTO;
import com.academia.api.model.Aluno;
import com.academia.api.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<AlunoResponseDTO> listarTodos(){
        return alunoRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public AlunoResponseDTO buscarPorId(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
        return toResponseDTO(aluno);
    }

    public AlunoResponseDTO cadastrarAluno(AlunoRequestDTO dto){
        Aluno aluno = Aluno.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .dataNascimento(dto.getDataNascimento())
                .dataCadastro(LocalDate.now())
                .plano(dto.getPlano())
                .build();

        return toResponseDTO(alunoRepository.save(aluno));
    }

    public AlunoResponseDTO atualizarAluno(Long id, AlunoRequestDTO dto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());

        return toResponseDTO(alunoRepository.save(aluno));
    }

    public void deletarAluno(Long id){
        try {
            alunoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Aluno não encontrado!");
        }
    }

    public AlunoResponseDTO toResponseDTO(Aluno aluno){
        AlunoResponseDTO dto = new AlunoResponseDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setTelefone(aluno.getTelefone());
        dto.setDataNascimento(aluno.getDataNascimento());
        dto.setDataCadastro(aluno.getDataCadastro());
        dto.setPlano(aluno.getPlano());
        return dto;
    }
}
