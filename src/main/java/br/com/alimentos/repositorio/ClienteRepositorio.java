package br.com.alimentos.repositorio;

import br.com.alimentos.dto.ClientesDto;
import br.com.alimentos.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
    @Query(value = "select c from Cliente c where upper(trim(c.nome)) like %?1% ")
    List<ClientesDto> findByNome(String nome);
}
