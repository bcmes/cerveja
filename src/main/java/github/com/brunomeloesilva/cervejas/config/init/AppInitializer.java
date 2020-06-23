package github.com.brunomeloesilva.cervejas.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import github.com.brunomeloesilva.cervejas.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
		//Aqui eu vou indicar qual a classe de configuracao que mostra onde está meus controllers
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
		//Do nome da aplicação para frente será entregado para o DispatcherServlet
	}
	
	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter }; 
	}

}
