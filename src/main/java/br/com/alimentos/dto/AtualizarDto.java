package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;

public record AtualizarDto(
        Long id,
        String nome,
        String fone) {
    public AtualizarDto(Cliente atualizar) {
        this(
                atualizar.getId(),
                atualizar.getNome(),
                atualizar.getFone());
    }
}
