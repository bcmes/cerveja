package github.com.brunomeloesilva.cervejas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.cervejas.model.Ciadade;

public interface Cidades extends JpaRepository<Ciadade, Long>{

	public List<Ciadade> findByEstadoCodigo(Long codigoEstado);
}
