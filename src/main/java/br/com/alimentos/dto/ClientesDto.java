package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;

public record ClientesDto(
        Long id,
        String nome,
        String fone) {

    public ClientesDto(Cliente clientes){
        this(
                clientes.getId(),
                clientes.getNome(),
                clientes.getFone()
        );
    }


    public ClientesDto(ClientesDto clientesDto) {
        this(
                clientesDto.id(),
                clientesDto.nome(),
                clientesDto.fone()
        );
    }
}
