package br.com.alimentos.entidade;

import br.com.alimentos.dto.AtualizarDto;
import br.com.alimentos.dto.ClienteDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fone;

    public Cliente() {
    }

    public Cliente(ClienteDto clienteDto) {
        this.nome = clienteDto.nome();
        this.fone = clienteDto.fone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void atualizar(AtualizarDto atualizarDto) {
        if(atualizarDto.nome() != null){
            this.nome = atualizarDto.nome();
        }
        if(atualizarDto.fone() != null){
            this.fone = atualizarDto.fone();
        }
    }
}
