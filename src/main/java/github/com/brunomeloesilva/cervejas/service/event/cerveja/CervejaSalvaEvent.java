package github.com.brunomeloesilva.cervejas.service.event.cerveja;

import org.springframework.util.StringUtils;

import github.com.brunomeloesilva.cervejas.model.Cerveja;


public class CervejaSalvaEvent {

	private Cerveja cerveja;

	public CervejaSalvaEvent(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}
	
	public boolean temFoto() {
		return !StringUtils.isEmpty(cerveja.getFoto());
	}
	
}