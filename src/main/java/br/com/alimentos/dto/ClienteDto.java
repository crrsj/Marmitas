package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ClienteDto(

        @NotBlank(message = "não pode estar em branco !")
        String nome,
        @NotBlank(message = "não pode estar em branco !")
        String fone) {
    public ClienteDto(Cliente salvar) {
        this(
                salvar.getNome(),
                salvar.getFone()
        );
    }
}
