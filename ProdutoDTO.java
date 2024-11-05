package com.exemplo.padaria.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoDTO {
    @NotEmpty
    private String nome;

    private String descricao;

    @NotNull
    @DecimalMin("0.01")
    private Double preco;

    private String imagem;

    // Getters e Setters
}
