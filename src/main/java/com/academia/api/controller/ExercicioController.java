package com.academia.api.controller;

import com.academia.api.dto.ExercicioResponseDTO;
import com.academia.api.service.ExercicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<ExercicioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(exercicioService.listarTodos());
    }
}
