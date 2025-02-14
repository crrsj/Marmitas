package br.com.alimentos.repositorio;

import br.com.alimentos.entidade.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco,Long> {
}
