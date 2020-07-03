package github.com.brunomeloesilva.cervejas.repository.helper.cerveja;

import java.util.List;

import github.com.brunomeloesilva.cervejas.model.Cerveja;
import github.com.brunomeloesilva.cervejas.repository.filter.CervejaFilter;

public interface CervejasQueries {
	
	public List<Cerveja> filtrar(CervejaFilter filtro);
}
