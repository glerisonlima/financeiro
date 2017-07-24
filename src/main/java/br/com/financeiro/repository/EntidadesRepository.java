package br.com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.financeiro.model.Entidade;

@Repository
public interface EntidadesRepository extends JpaRepository<Entidade, Long>{

}
