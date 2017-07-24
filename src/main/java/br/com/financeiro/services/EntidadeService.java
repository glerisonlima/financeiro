package br.com.financeiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financeiro.model.Entidade;
import br.com.financeiro.repository.EntidadesRepository;

@Service
public class EntidadeService {

	@Autowired
	private EntidadesRepository repository;
	
	public void salvar(Entidade entidade){
		repository.save(entidade);
	}
}
