package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;
import br.com.alimentos.entidade.Prato;
import br.com.alimentos.enums.*;

import java.time.LocalDate;
import java.util.Date;

public class PratosDto {
    private Long id;
    private Date data;
    private Tipo tipo;
    private Carnes carnes;
    private Feijao feijao;
    private Arroz arroz;
    private Saladas saladas;
    private String descricao;
    private Double valor;
    private Cliente cliente;

    public PratosDto() {
    }

    public PratosDto(Prato pratos){
      this.id = pratos.getId();
      this.data = pratos.getData();
      this.tipo = pratos.getTipo();
      this.carnes = pratos.getCarnes();
      this.feijao = pratos.getFeijao();
      this.arroz = pratos.getArroz();
      this.saladas = pratos.getSaladas();
      this.descricao = pratos.getDescricao();
      this.valor = pratos.getValor();
      this.cliente = pratos.getCliente();
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
