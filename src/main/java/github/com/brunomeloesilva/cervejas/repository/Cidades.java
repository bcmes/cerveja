package github.com.brunomeloesilva.cervejas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.cervejas.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Long>{

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
}
