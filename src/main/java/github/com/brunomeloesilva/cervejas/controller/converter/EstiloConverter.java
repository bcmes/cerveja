package github.com.brunomeloesilva.cervejas.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import github.com.brunomeloesilva.cervejas.model.Estilo;

public class EstiloConverter implements Converter<String, Estilo>{

	@Override
	public Estilo convert(String codigo) {
		//Nem precisa desse if
		if (!StringUtils.isEmpty(codigo)) {
			Estilo estilo  = new Estilo();
			estilo.setCodigo(Long.valueOf(codigo));
			return estilo;
		}
		return null;
	}

}
