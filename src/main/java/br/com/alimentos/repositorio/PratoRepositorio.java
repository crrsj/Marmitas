package br.com.alimentos.repositorio;

import br.com.alimentos.entidade.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepositorio extends JpaRepository<Prato,Long> {
}
