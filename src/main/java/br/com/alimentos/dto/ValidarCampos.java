package br.com.alimentos.dto;

import org.springframework.validation.FieldError;

public record ValidarCampos(String campo,String mensagem) {
    public ValidarCampos(FieldError erros){
        this(erros.getField(),erros.getDefaultMessage());
    }
}
