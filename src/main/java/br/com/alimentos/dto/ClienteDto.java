package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;

import java.time.LocalDate;

public record ClienteDto(

        String nome,
        String fone) {
    public ClienteDto(Cliente salvar) {
        this(
                salvar.getNome(),
                salvar.getFone()
        );
    }
}
