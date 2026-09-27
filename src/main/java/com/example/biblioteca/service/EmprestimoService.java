package com.example.biblioteca.service;

import com.example.biblioteca.dto.EmprestimoRequestDTO;
import com.example.biblioteca.dto.EmprestimoResponseDTO;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public List<EmprestimoResponseDTO> listarTodos() {
        return emprestimoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public EmprestimoResponseDTO buscarPorId(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        return toResponseDTO(emprestimo);
    }

    public EmprestimoResponseDTO criar(EmprestimoRequestDTO dto) {
        Livro livro = livroRepository.findById(dto.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Emprestimo emprestimo = Emprestimo.builder()
                .livro(livro)
                .usuario(usuario)
                .dataEmprestimo(dto.getDataEmprestimo())
                .dataDevolucaoPrevista(dto.getDataDevolucaoPrevista())
                .status(Emprestimo.StatusEmprestimo.ATIVO)
                .build();

        emprestimo = emprestimoRepository.save(emprestimo);
        return toResponseDTO(emprestimo);
    }

    public EmprestimoResponseDTO registrarDevolucao(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimo.setDataDevolucaoReal(LocalDate.now());
        emprestimo.setStatus(Emprestimo.StatusEmprestimo.DEVOLVIDO);

        emprestimo = emprestimoRepository.save(emprestimo);
        return toResponseDTO(emprestimo);
    }

    public void deletar(Long id) {
        emprestimoRepository.deleteById(id);
    }

    private EmprestimoResponseDTO toResponseDTO(Emprestimo emprestimo) {
        return new EmprestimoResponseDTO(
                emprestimo.getId(),
                emprestimo.getLivro().getId(),
                emprestimo.getLivro().getTitulo(),
                emprestimo.getUsuario().getId(),
                emprestimo.getUsuario().getNome(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucaoPrevista(),
                emprestimo.getDataDevolucaoReal(),
                emprestimo.getStatus()
        );
    }
}