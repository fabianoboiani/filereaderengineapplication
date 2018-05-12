package br.com.prova.filereaderengine.domain;

import java.math.BigDecimal;
import java.util.List;

public class Vendedor extends DomainBasico {
	private String cpf; 
	private BigDecimal salario;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public static class Factory {
		public static Vendedor criar(List<String> dados) {
			Vendedor vendedor = new Vendedor();
			vendedor.setCodigo(Long.valueOf(dados.get(0)));
			vendedor.setCpf(dados.get(1));
			vendedor.setNome(dados.get(2));
			vendedor.setSalario(new BigDecimal(dados.get(3)));
			return vendedor;
		}
	}
}
