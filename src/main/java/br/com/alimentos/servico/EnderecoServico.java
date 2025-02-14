package br.com.alimentos.servico;

import br.com.alimentos.dto.EnderecoDto;
import br.com.alimentos.entidade.Endereco;
import br.com.alimentos.repositorio.ClienteRepositorio;
import br.com.alimentos.repositorio.EnderecoRepositorio;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class EnderecoServico {

    private final EnderecoRepositorio enderecoRepositorio;

    private final ClienteRepositorio clienteRepositorio;

    public EnderecoServico(EnderecoRepositorio enderecoRepositorio, ClienteRepositorio clienteRepositorio) {
        this.enderecoRepositorio = enderecoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public Endereco salvarEnderecos(EnderecoDto enderecoDto,Long clienteId)throws Exception {
        var endereco = new Endereco(enderecoDto);
        var cliente = clienteRepositorio.findById(clienteId).orElseThrow();
        endereco.setCliente(cliente);
        URL url = new URL("https://viacep.com.br/ws/"+endereco.getCep()+"/json/");
        URLConnection conexao = url.openConnection();
        InputStream input = conexao.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        String cep = "";
        StringBuilder sb = new StringBuilder();
        while((cep = bf.readLine()) != null){
            sb.append(cep);

        }

        var cadastroCep = new Gson().fromJson(sb.toString(),Endereco.class);
        endereco.setCep(cadastroCep.getCep());
        endereco.setLogradouro(cadastroCep.getLogradouro());
        endereco.setComplemento(cadastroCep.getComplemento());
        endereco.setBairro(cadastroCep.getBairro());
        endereco.setLocalidade(cadastroCep.getLocalidade());
        endereco.setEstado(cadastroCep.getEstado());
            return  enderecoRepositorio.save(endereco);

    }
}
