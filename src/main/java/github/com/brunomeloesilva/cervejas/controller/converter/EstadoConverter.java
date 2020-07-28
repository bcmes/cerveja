package github.com.brunomeloesilva.cervejas.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import github.com.brunomeloesilva.cervejas.model.Estado;

public class EstadoConverter implements Converter<String, Estado>{

	@Override
	public Estado convert(String codigo) {
		//Nem precisa desse if
		if (!StringUtils.isEmpty(codigo)) {
			Estado estado  = new Estado();
			estado.setCodigo(Long.valueOf(codigo));
			return estado;
		}
		return null;
	}

}
