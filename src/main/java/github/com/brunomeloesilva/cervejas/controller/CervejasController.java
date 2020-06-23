package github.com.brunomeloesilva.cervejas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import github.com.brunomeloesilva.cervejas.model.Cerveja;

@Controller
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("mensagem", "Erro no formulário !!");
			System.out.println("Tem erro sim !");
			return "cerveja/CadastroCerveja";
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		System.out.println("SKU>>> " + cerveja.getSku());
		return "redirect:/cervejas/novo";
		//return "redirect: https://www.google.com/";
	}
}

/* BindingResult - Se ouver erros eles são entregues ao BindingResult.
 * Model - para passar objetos/dados para view
 * **** model.addAttribute("mensagem", "Erro no formulário !!") - Ao add o atributo, deve chamar pelo mesmo nome no html
 * redirectAttributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso") - Quando se usar redirect 
 * não adianta usar  model.addAttribute que não vai funcionar, deve usar redirectAttributes.addFlashAttribute
 * */
