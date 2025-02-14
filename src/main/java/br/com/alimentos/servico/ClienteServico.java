package br.com.alimentos.servico;


import br.com.alimentos.dto.AtualizarDto;
import br.com.alimentos.dto.ClienteDto;
import br.com.alimentos.dto.ClientesDto;
import br.com.alimentos.entidade.Cliente;
import br.com.alimentos.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente salvarCliente(ClienteDto clienteDto){
      var salvar = new Cliente(clienteDto);
      return clienteRepositorio.save(salvar);
    }

    public List<ClientesDto> buscarClientes(){
        return clienteRepositorio.findAll().stream().map(ClientesDto::new).toList();
    }

    public Cliente buscarPorId(Long id){
        Optional<Cliente>buscar = clienteRepositorio.findById(id);
        return buscar.orElseThrow();
    }

    public Cliente atualizarClientes(AtualizarDto atualizarDto){
        var atualize = clienteRepositorio.getReferenceById(atualizarDto.id());
        atualize.atualizar(atualizarDto);
        return clienteRepositorio.save(atualize);
    }

    public void excluirCliente(Long id){
        clienteRepositorio.findById(id);
        clienteRepositorio.deleteById(id);
    }

    public List<ClientesDto> buscarPorNome(String nome){
        return clienteRepositorio.findByNome(nome.trim().toUpperCase()).stream().map(ClientesDto::new).toList();

    }
}
