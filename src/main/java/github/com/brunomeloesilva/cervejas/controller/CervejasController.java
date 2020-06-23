package github.com.brunomeloesilva.cervejas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import github.com.brunomeloesilva.cervejas.model.Cerveja;

@Controller
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("Tem erro sim !");
		}
		System.out.println("SKU>>> " + cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
}
