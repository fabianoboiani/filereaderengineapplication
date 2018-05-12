package br.com.prova.filereaderengine.domain;

import java.util.List;

public class Cliente extends DomainBasico {
	private String cnpj;
	private String areaAtuacao;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	public static class Factory {
		public static Cliente criar(List<String> dados) {
			Cliente cliente = new Cliente();
			cliente.setCodigo(Long.valueOf(dados.get(0)));
			cliente.setCnpj(dados.get(1));
			cliente.setNome(dados.get(2));
			cliente.setAreaAtuacao(dados.get(3));
			return cliente;
		}
	}
}
