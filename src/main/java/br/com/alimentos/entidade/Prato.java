package br.com.alimentos.entidade;

import br.com.alimentos.dto.PratoDto;
import br.com.alimentos.dto.PratosDto;
import br.com.alimentos.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_pratos")
@Data
@NoArgsConstructor
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date data;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Carnes carnes;
    @Enumerated(EnumType.STRING)
    private Feijao feijao;
    @Enumerated(EnumType.STRING)
    private Arroz arroz;
    @Enumerated(EnumType.STRING)
    private Saladas saladas;
    private String descricao;
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Prato(PratoDto pratoDto) {
        this.data = pratoDto.getData();
        this.tipo = pratoDto.getTipo();
        this.carnes = pratoDto.getCarnes();
        this.feijao = pratoDto.getFeijao();
        this.arroz = pratoDto.getArroz();
        this.saladas = pratoDto.getSaladas();
        this.descricao = pratoDto.getDescricao();
        this.valor = pratoDto.getValor();

    }

    public Prato(PratosDto pratosDto) {
        this.id = pratosDto.getId();
        this.data = pratosDto.getData();
        this.tipo = pratosDto.getTipo();
        this.carnes = pratosDto.getCarnes();
        this.feijao = pratosDto.getFeijao();
        this.arroz = pratosDto.getArroz();
        this.saladas = pratosDto.getSaladas();
        this.descricao = pratosDto.getDescricao();
        this.valor = pratosDto.getValor();
    }

    public Prato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Carnes getCarnes() {
        return carnes;
    }

    public void setCarnes(Carnes carnes) {
        this.carnes = carnes;
    }

    public Feijao getFeijao() {
        return feijao;
    }

    public void setFeijao(Feijao feijao) {
        this.feijao = feijao;
    }

    public Arroz getArroz() {
        return arroz;
    }

    public void setArroz(Arroz arroz) {
        this.arroz = arroz;
    }

    public Saladas getSaladas() {
        return saladas;
    }

    public void setSaladas(Saladas saladas) {
        this.saladas = saladas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
