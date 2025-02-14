package br.com.alimentos.dto;

import br.com.alimentos.entidade.Cliente;
import br.com.alimentos.entidade.Endereco;

public class EnderecoDto {


    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String estado;
    private Cliente cliente;
    public EnderecoDto() {
    }

    public EnderecoDto(Endereco salvar) {
       this.cep = salvar.getCep();
        this.logradouro = salvar.getLogradouro();
        this.numero = salvar.getNumero();
        this.complemento = salvar.getComplemento();
        this.bairro = salvar.getBairro();
        this.localidade = salvar.getLocalidade();
        this.estado = salvar.getEstado();
        this.cliente = salvar.getCliente();
    }



    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
