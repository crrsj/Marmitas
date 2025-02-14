package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;
import jakarta.validation.constraints.NotBlank;

public record AtualizarDto(
        Long id,
        @NotBlank(message = "não pode estar em branco !")
        String nome,
        @NotBlank(message = "não pode estar em branco !")
        String fone) {
    public AtualizarDto(Cliente atualizar) {
        this(
                atualizar.getId(),
                atualizar.getNome(),
                atualizar.getFone());
    }
}
