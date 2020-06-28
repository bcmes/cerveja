package github.com.brunomeloesilva.cervejas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.com.brunomeloesilva.cervejas.model.Estilo;
import github.com.brunomeloesilva.cervejas.repository.Estilos;

@Service
public class CadastroEstiloService {
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo) {
		estilos.save(estilo);
	}
}
