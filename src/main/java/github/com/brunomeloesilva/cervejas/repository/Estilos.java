package github.com.brunomeloesilva.cervejas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.brunomeloesilva.cervejas.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>{

}
