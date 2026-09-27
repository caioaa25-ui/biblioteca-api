package com.example.biblioteca.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoRequestDTO {

    @NotNull(message = "O livro é obrigatório")
    private Long livroId;

    @NotNull(message = "O usuário é obrigatório")
    private Long usuarioId;

    @NotNull(message = "A data do empréstimo é obrigatória")
    private LocalDate dataEmprestimo;

    @NotNull(message = "A data de devolução prevista é obrigatória")
    private LocalDate dataDevolucaoPrevista;
}