package br.com.alimentos.validacao;

import br.com.alimentos.dto.MensagemDeErro;
import br.com.alimentos.dto.ValidarCampos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemDeErro>ObjetoNaoEncontrado(){
       var erros  = new MensagemDeErro(HttpStatus.NOT_FOUND,"Objeto não encontrado !");
       return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validandoCampos(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(ValidarCampos::new).toList());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<MensagemDeErro>cepIncvalido(){
        var erro = new MensagemDeErro(HttpStatus.BAD_REQUEST,"CEP inválido ou não existe !");
        return new ResponseEntity<>(erro,HttpStatus.BAD_REQUEST);
    }
}
