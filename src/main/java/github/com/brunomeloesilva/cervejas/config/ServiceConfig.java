package github.com.brunomeloesilva.cervejas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import github.com.brunomeloesilva.cervejas.service.CadastroCervejaService;
import github.com.brunomeloesilva.cervejas.storage.FotoStorage;
import github.com.brunomeloesilva.cervejas.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}
}
