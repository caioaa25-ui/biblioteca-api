package com.example.biblioteca.controller;

import com.example.biblioteca.dto.AutorRequestDTO;
import com.example.biblioteca.dto.AutorResponseDTO;
import com.example.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listarTodos() {
        return ResponseEntity.ok(autorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> criar(@Valid @RequestBody AutorRequestDTO dto) {
        return ResponseEntity.ok(autorService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AutorRequestDTO dto) {
        return ResponseEntity.ok(autorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}