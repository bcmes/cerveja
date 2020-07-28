package github.com.brunomeloesilva.cervejas.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import github.com.brunomeloesilva.cervejas.model.Cidade;

public class CidadeConverter implements Converter<String, Cidade>{

	@Override
	public Cidade convert(String codigo) {
		//Nem precisa desse if
		if (!StringUtils.isEmpty(codigo)) {
			Cidade cidade  = new Cidade();
			cidade.setCodigo(Long.valueOf(codigo));
			return cidade;
		}
		return null;
	}

}
