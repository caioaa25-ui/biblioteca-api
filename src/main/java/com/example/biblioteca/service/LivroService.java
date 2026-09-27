package com.example.biblioteca.service;

import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Regras de negócio relacionadas ao cadastro e consulta de livros.
 */
@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    @Transactional
    public LivroResponseDTO criar(LivroRequestDTO dto) {
        Autor autor = buscarAutorOuFalhar(dto.getAutorId());

        Livro livro = Livro.builder()
                .titulo(dto.getTitulo())
                .isbn(dto.getIsbn())
                .quantidadeEstoque(dto.getQuantidadeEstoque())
                .autor(autor)
                .build();

        Livro salvo = livroRepository.save(livro);
        return converterParaResponseDTO(salvo);
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> listarTodos() {
        return livroRepository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public LivroResponseDTO buscarPorId(Long id) {
        Livro livro = buscarLivroOuFalhar(id);
        return converterParaResponseDTO(livro);
    }

    @Transactional
    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = buscarLivroOuFalhar(id);
        Autor autor = buscarAutorOuFalhar(dto.getAutorId());

        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        livro.setAutor(autor);

        Livro atualizado = livroRepository.save(livro);
        return converterParaResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        Livro livro = buscarLivroOuFalhar(id);
        livroRepository.delete(livro);
    }

    private Livro buscarLivroOuFalhar(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado com id: " + id));
    }

    private Autor buscarAutorOuFalhar(Long autorId) {
        return autorRepository.findById(autorId)
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com id: " + autorId));
    }

    private LivroResponseDTO converterParaResponseDTO(Livro livro) {
        return LivroResponseDTO.builder()
                .id(livro.getId())
                .titulo(livro.getTitulo())
                .isbn(livro.getIsbn())
                .quantidadeEstoque(livro.getQuantidadeEstoque())
                .autorId(livro.getAutor().getId())
                .autorNome(livro.getAutor().getNome())
                .build();
    }
}