package com.academia.api.controller;

import com.academia.api.dto.FichaRequestDTO;
import com.academia.api.dto.FichaResponseDTO;
import com.academia.api.service.FichaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FichaController {

    private final FichaService fichaService;

    @GetMapping
    public ResponseEntity<List<FichaResponseDTO>> listarTodos(@RequestParam(required = false) Long usuarioId) {
        return ResponseEntity.ok(fichaService.listarTodos(usuarioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fichaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<FichaResponseDTO> cadastrar(@RequestBody FichaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaService.cadastrarFicha(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaResponseDTO> atualizar(@PathVariable Long id, @RequestBody FichaRequestDTO dto) {
        return ResponseEntity.ok(fichaService.atualizarFicha(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fichaService.deletarFicha(id);
        return ResponseEntity.noContent().build();
    }
}
