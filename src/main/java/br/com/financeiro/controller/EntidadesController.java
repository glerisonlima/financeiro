package br.com.financeiro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.financeiro.model.Entidade;
import br.com.financeiro.services.EntidadeService;

@Controller
@RequestMapping("/entidades")
public class EntidadesController {

	private static final String INDEX = "entidade/CadastrarEntidade";
	
	@Autowired
	private EntidadeService entidadeService;
	
	@RequestMapping("/novo")
	public String novo() {
		return INDEX;
	}
	
	@RequestMapping(value="/novo", method=RequestMethod.POST)
	public String salvar(@Valid Entidade entidade, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Tem erro! "+result.getAllErrors().toString());
			return novo();
		}
		
		System.out.println("Entidade: " +entidade.toString());
		entidadeService.salvar(entidade);
		return novo();
	}
}
