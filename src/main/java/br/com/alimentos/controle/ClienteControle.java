package br.com.alimentos.controle;

import br.com.alimentos.dto.AtualizarDto;
import br.com.alimentos.dto.ClienteDto;
import br.com.alimentos.dto.ClientesDto;
import br.com.alimentos.servico.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {

    private final ClienteServico clienteServico;

    public ClienteControle(ClienteServico clienteServico) {
        this.clienteServico = clienteServico;
    }


    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar clientes.")
    @ApiResponse(responseCode = "201",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ClienteDto>salvarCliente(@RequestBody @Valid ClienteDto clienteDto){
        var salvar = clienteServico.salvarCliente(clienteDto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(salvar.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(salvar));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por listar clientes.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<ClientesDto>>buscarClientes(){
        var buscar = clienteServico.buscarClientes();
        return ResponseEntity.ok().body(buscar);
    }


    @PutMapping
    @Operation(summary = "Endpoint responsável por atualizar clientes.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AtualizarDto>atualizarCliente(@RequestBody @Valid AtualizarDto atualizarDto ){
        var atualizar = clienteServico.atualizarClientes(atualizarDto);
        return ResponseEntity.ok().body(new AtualizarDto(atualizar));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsável por buscar cliente pelo id.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<ClientesDto>buscarPorId(@PathVariable Long id){
        var buscarId = clienteServico.buscarPorId(id);
        return ResponseEntity.ok().body(new ClientesDto(buscarId));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsável por excluir clientes.")
    @ApiResponse(responseCode = "204",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
         clienteServico.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome")
    @Operation(summary = "Endpoint responsável por listar clientes pelo nome.")
    @ApiResponse(responseCode = "200",description = " success",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<ClientesDto>>buscarPorNome(@RequestParam("nome")String nome){
        var buscarNome = clienteServico.buscarPorNome(nome);
        return ResponseEntity.ok().body(buscarNome);
    }
}
