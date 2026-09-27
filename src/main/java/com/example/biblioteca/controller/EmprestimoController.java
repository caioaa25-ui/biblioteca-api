package com.example.biblioteca.controller;

import com.example.biblioteca.dto.EmprestimoRequestDTO;
import com.example.biblioteca.dto.EmprestimoResponseDTO;
import com.example.biblioteca.service.EmprestimoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(emprestimoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> criar(@Valid @RequestBody EmprestimoRequestDTO dto) {
        return ResponseEntity.ok(emprestimoService.criar(dto));
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<EmprestimoResponseDTO> registrarDevolucao(@PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.registrarDevolucao(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}