package br.com.prova.filereaderengine.domain;

public enum TipoDado {
	
	VENDEDOR("001"),
	CLIENTE("002"),
	VENDA("003");
	
	String codigo;
	
	private TipoDado(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
}
