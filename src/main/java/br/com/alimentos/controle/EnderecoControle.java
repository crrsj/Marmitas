package br.com.alimentos.controle;

import br.com.alimentos.dto.EnderecoDto;
import br.com.alimentos.servico.EnderecoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {

    private final EnderecoServico enderecoServico;

    public EnderecoControle(EnderecoServico enderecoServico) {
        this.enderecoServico = enderecoServico;


    }

    @PostMapping("/{clienteId}")
    @Operation(summary = "Endpoint responsável por buscar endereço na api viacep e salvar,utilizando o id do cliente.")
    @ApiResponse(responseCode = "201",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<EnderecoDto>salvarEndereco(@RequestBody EnderecoDto enderecoDto,
                                                     @PathVariable("clienteId")Long clienteId) throws Exception {
        var salvar = enderecoServico.salvarEnderecos(enderecoDto,clienteId);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id]")
                .buildAndExpand(salvar.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDto(salvar));
    }
}
