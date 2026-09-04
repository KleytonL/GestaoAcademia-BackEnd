package com.academia.api.controller;

import com.academia.api.dto.PlanoRequestDTO;
import com.academia.api.dto.PlanoResponseDTO;
import com.academia.api.service.PlanoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PlanoController {

    private final PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<PlanoResponseDTO>> listarTodos(@RequestParam(required = false) Boolean ativo) {
        return ResponseEntity.ok(planoService.listarTodos(ativo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(planoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlanoResponseDTO> cadastrar(@RequestBody @Valid PlanoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(planoService.cadastrarPlano(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid PlanoRequestDTO dto){
        return ResponseEntity.ok(planoService.atualizarPlano(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        planoService.deletarPlano(id);
        return ResponseEntity.noContent().build();
    }
}
