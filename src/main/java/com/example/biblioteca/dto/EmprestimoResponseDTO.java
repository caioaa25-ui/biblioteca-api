package com.example.biblioteca.dto;

import com.example.biblioteca.model.Emprestimo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoResponseDTO {

    private Long id;
    private Long livroId;
    private String livroTitulo;
    private Long usuarioId;
    private String usuarioNome;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private Emprestimo.StatusEmprestimo status;

    public EmprestimoResponseDTO(Long id, Long livroId, String livroTitulo,
                                 Long usuarioId, String usuarioNome,
                                 LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista,
                                 LocalDate dataDevolucaoReal, Emprestimo.StatusEmprestimo status) {
        this.id = id;
        this.livroId = livroId;
        this.livroTitulo = livroTitulo;
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = status;
    }
}