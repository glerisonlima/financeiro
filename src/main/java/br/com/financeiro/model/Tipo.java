package br.com.financeiro.model;

public enum Tipo {

	ENTRADA("Entrada"),
	SAIDA("Saida");
	
	private String descricao;
	
	Tipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
