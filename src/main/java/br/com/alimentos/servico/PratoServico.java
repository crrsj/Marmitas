package br.com.alimentos.servico;

import br.com.alimentos.dto.PratoDto;
import br.com.alimentos.dto.PratosDto;
import br.com.alimentos.entidade.Prato;
import br.com.alimentos.repositorio.ClienteRepositorio;
import br.com.alimentos.repositorio.PratoRepositorio;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PratoServico {

    private final ClienteRepositorio clienteRepositorio;
    private final PratoRepositorio pratoRepositorio;

    public PratoServico(ClienteRepositorio clienteRepositorio, PratoRepositorio pratoRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.pratoRepositorio = pratoRepositorio;
    }

    public Prato salvarPrato(PratoDto pratoDto,Long clienteId){
        var prato = new Prato(pratoDto);
        prato.setData(new Date());
        var cliente = clienteRepositorio.findById(clienteId).orElseThrow();
        prato.setCliente(cliente);
        return pratoRepositorio.save(prato);
    }

    public List<PratosDto>listarPratos(){
        return pratoRepositorio.findAll().stream().map(PratosDto::new).toList();
    }

    public Prato buscarPorId(Long id){
        Optional<Prato> buscar = pratoRepositorio.findById(id);
        return buscar.orElseThrow();
    }

    public Prato atualizarPrato(PratosDto pratosDto,Long id){
        var atualizar = new Prato(pratosDto);
        atualizar.setId(id);
        return pratoRepositorio.save(atualizar);
    }

    public void excluirPrato(Long id){
        pratoRepositorio.deleteById(id);
    }
}
