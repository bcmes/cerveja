package github.com.brunomeloesilva.cervejas.config;

import java.math.BigDecimal;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;

import github.com.brunomeloesilva.cervejas.controller.CervejasController;
import github.com.brunomeloesilva.cervejas.controller.converter.EstiloConverter;
import github.com.brunomeloesilva.cervejas.thymeleaf.BrewerDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@ComponentScan(basePackageClasses = CervejasController.class)
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
		springResourceTemplateResolver.setApplicationContext(applicationContext);
		springResourceTemplateResolver.setPrefix("classpath:/templates/");
		springResourceTemplateResolver.setSuffix(".html");
		springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
		return springResourceTemplateResolver;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
	
	@Bean
	public TemplateEngine templateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setEnableSpringELCompiler(true);
		springTemplateEngine.setTemplateResolver(templateResolver());
		
		springTemplateEngine.addDialect(new LayoutDialect()); //vem da dependencia do nz.net.ultraq.thymeleaf
		springTemplateEngine.addDialect(new BrewerDialect());
		springTemplateEngine.addDialect(new DataAttributeDialect());
		return springTemplateEngine;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(templateEngine());
		thymeleafViewResolver.setCharacterEncoding("UTF-8");
		return thymeleafViewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		//para chamar os recursos estaticos (chamadas a css e js) sem usar um controller
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		conversionService.addConverter(new EstiloConverter());
		
		NumberStyleFormatter bigDecimalStyleFormatter = new NumberStyleFormatter("#,##0.00");
		conversionService.addFormatterForFieldType(BigDecimal.class, bigDecimalStyleFormatter);
		
		NumberStyleFormatter intergerStyleFormatter = new NumberStyleFormatter("#,##0");
		conversionService.addFormatterForFieldType(Integer.class, intergerStyleFormatter);
		
		return conversionService;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
