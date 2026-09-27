package com.example.biblioteca.service;

import com.example.biblioteca.dto.AutorRequestDTO;
import com.example.biblioteca.dto.AutorResponseDTO;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<AutorResponseDTO> listarTodos() {
        return autorRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public AutorResponseDTO buscarPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        return toResponseDTO(autor);
    }

    public AutorResponseDTO criar(AutorRequestDTO dto) {
        Autor autor = Autor.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .build();
        autor = autorRepository.save(autor);
        return toResponseDTO(autor);
    }

    public AutorResponseDTO atualizar(Long id, AutorRequestDTO dto) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autor = autorRepository.save(autor);
        return toResponseDTO(autor);
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }

    private AutorResponseDTO toResponseDTO(Autor autor) {
        return new AutorResponseDTO(autor.getId(), autor.getNome(), autor.getNacionalidade());
    }
}