package github.com.brunomeloesilva.cervejas.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import github.com.brunomeloesilva.cervejas.model.Cerveja;
import github.com.brunomeloesilva.cervejas.repository.filter.CervejaFilter;

public interface CervejasQueries {
	
	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
}
