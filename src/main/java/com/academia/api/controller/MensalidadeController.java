package com.academia.api.controller;

import com.academia.api.dto.MensalidadeResponseDTO;
import com.academia.api.repository.MensalidadeRepository;
import com.academia.api.service.MensalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensalidades")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MensalidadeController {

    private final MensalidadeRepository mensalidadeRepository;
    private final MensalidadeService mensalidadeService;

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<MensalidadeResponseDTO>> listarPorAluno(@PathVariable Long alunoId){
        return ResponseEntity.ok(mensalidadeService.listarPorAluno(alunoId));
    }
}
