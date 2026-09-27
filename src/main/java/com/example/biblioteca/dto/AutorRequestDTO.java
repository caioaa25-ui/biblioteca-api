package com.example.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorRequestDTO {

    @NotBlank(message = "O nome do autor é obrigatório")
    @Size(max = 150, message = "O nome do autor deve ter no máximo 150 caracteres")
    private String nome;

    @Size(max = 100, message = "A nacionalidade deve ter no máximo 100 caracteres")
    private String nacionalidade;
}