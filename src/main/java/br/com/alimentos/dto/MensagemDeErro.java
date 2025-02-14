package br.com.alimentos.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErro(
                             HttpStatus status,
                             String mensagem) {
}
