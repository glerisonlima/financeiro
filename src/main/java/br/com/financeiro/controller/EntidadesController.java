package br.com.financeiro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.financeiro.model.Entidade;
import br.com.financeiro.repository.EntidadesRepository;
import br.com.financeiro.services.EntidadeService;

@Controller
@RequestMapping("/entidades")
public class EntidadesController {

	private static final String INDEX = "entidade/CadastrarEntidade";
	
	@Autowired
	private EntidadeService entidadeService;
	
	@Autowired
	private EntidadesRepository repository;
	
	@RequestMapping("/novo")
	public String novo(Entidade entidade) {
		return INDEX;
	}
	
	@RequestMapping(value="/novo", method=RequestMethod.POST)
	public String salvar(@Valid Entidade entidade, BindingResult result) {
		if(result.hasErrors()) {
			return novo(entidade);
		}
		
		System.out.println("Entidade: " +entidade.toString());
		entidadeService.salvar(entidade);
		return "redirect:/entidades/novo";
	}
	
	@RequestMapping
	public String pesquisar(Entidade entidade, Model model) {
		String nome = entidade.getNome() == null ? "%" : entidade.getNome();
		model.addAttribute("entidades", repository.findByNomeContainingIgnoreCase(nome));
		return "entidade/PesquisarEntidade";
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Entidade entidade) {
		ModelAndView mv =  new ModelAndView(INDEX);
		mv.addObject(entidade);
		return mv;
	}
}
