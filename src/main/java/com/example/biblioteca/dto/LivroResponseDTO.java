package com.example.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dados devolvidos pela API ao consultar um livro.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroResponseDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private Integer quantidadeEstoque;
    private Long autorId;
    private String autorNome;
}