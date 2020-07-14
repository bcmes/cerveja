package github.com.brunomeloesilva.cervejas.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import github.com.brunomeloesilva.cervejas.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import github.com.brunomeloesilva.cervejas.thymeleaf.processor.MessageElementTagProcessor;
import github.com.brunomeloesilva.cervejas.thymeleaf.processor.OrderElementTagProcessor;


public class BrewerDialect extends AbstractProcessorDialect {

	public BrewerDialect() {
		super("AlgaWorks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		return processadores;
	}

}