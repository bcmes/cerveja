package github.com.brunomeloesilva.cervejas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.brunomeloesilva.cervejas.model.Cerveja;


@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {
	
	//public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}
