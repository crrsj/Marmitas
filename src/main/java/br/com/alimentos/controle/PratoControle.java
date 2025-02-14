package br.com.alimentos.controle;

import br.com.alimentos.dto.PratoDto;
import br.com.alimentos.dto.PratosDto;
import br.com.alimentos.entidade.Prato;
import br.com.alimentos.servico.PratoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoControle {

    private final PratoServico pratoServico;

    public PratoControle(PratoServico pratoServico) {
        this.pratoServico = pratoServico;
    }


    @PostMapping("/{clienteId}")
    @Operation(summary = "Endpoint responsável por cadastrar pratos utilizando o id do cliente.")
    @ApiResponse(responseCode = "201",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PratoDto>salvarPrato(@RequestBody PratoDto pratoDto,
                                               @PathVariable("clienteId")Long clienteId){
        var salvar = pratoServico.salvarPrato(pratoDto,clienteId);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(salvar.getId()).toUri();
        return ResponseEntity.created(uri).body(new PratoDto(salvar));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsável por buscar prato pelo id.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PratosDto>buscarId(@PathVariable Long id){
        var buscar = pratoServico.buscarPorId(id);
        return ResponseEntity.ok().body(new PratosDto(buscar));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por listar pratos.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<PratosDto>>listarTodos(){
        var listar = pratoServico.listarPratos();
        return ResponseEntity.ok().body(listar);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint responsável por atualizar prato pelo id.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<PratosDto>atualizarPrato(@RequestBody PratosDto pratosDto,@PathVariable Long id){
        var atualizar = pratoServico.atualizarPrato(pratosDto,id);
        return ResponseEntity.ok().body(new PratosDto(atualizar));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsável por excluir pratos.")
    @ApiResponse(responseCode = "204",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirPrato(@PathVariable Long id){
        pratoServico.excluirPrato(id);
        return ResponseEntity.noContent().build();
    }
}
