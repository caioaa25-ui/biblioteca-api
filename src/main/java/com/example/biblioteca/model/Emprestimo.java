package com.example.biblioteca.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Representa o empréstimo de um livro a um usuário, com controle de status
 * e datas de devolução prevista e real.
 */
@Entity
@Table(name = "emprestimos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"livro", "usuario"})
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O empréstimo precisa estar vinculado a um livro")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @NotNull(message = "O empréstimo precisa estar vinculado a um usuário")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull(message = "A data do empréstimo é obrigatória")
    private LocalDate dataEmprestimo;

    @NotNull(message = "A data de devolução prevista é obrigatória")
    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoReal;

    @NotNull(message = "O status do empréstimo é obrigatório")
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;

    /**
     * Status possíveis de um empréstimo.
     */
    public enum StatusEmprestimo {
        ATIVO,
        DEVOLVIDO,
        ATRASADO
    }
}