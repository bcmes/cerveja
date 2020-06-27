package github.com.brunomeloesilva.cervejas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import github.com.brunomeloesilva.cervejas.model.Cerveja;
import github.com.brunomeloesilva.cervejas.model.Origem;
import github.com.brunomeloesilva.cervejas.model.Sabor;
import github.com.brunomeloesilva.cervejas.repository.Estilos;
import github.com.brunomeloesilva.cervejas.service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	@Autowired
	private Estilos estilos;
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView modelAndView = new ModelAndView("cerveja/CadastroCerveja");
		modelAndView.addObject("sabores", Sabor.values());
		modelAndView.addObject("estilos", estilos.findAll());
		modelAndView.addObject("origens", Origem.values());
		return modelAndView;
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return novo(cerveja);
		}
		
		cadastroCervejaService.salvar(cerveja);
		redirectAttributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		return new ModelAndView("redirect:/cervejas/novo");
	}
	
}

/* BindingResult - Se ouver erros eles são entregues ao BindingResult.
 * Model - para passar objetos/dados para view
 * **** model.addAttribute("mensagem", "Erro no formulário !!") - Ao add o atributo, deve chamar pelo mesmo nome no html
 * redirectAttributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso") - Quando se usar redirect 
 * não adianta usar  model.addAttribute que não vai funcionar, deve usar redirectAttributes.addFlashAttribute
 * */
//return "redirect: https://www.google.com/";