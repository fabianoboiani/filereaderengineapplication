package br.com.prova.filereaderengine.domain;

import java.util.List;

import br.com.prova.filereaderengine.util.FabricaDeItens;

public class Venda extends DomainBasico {
	private String idVenda;
	private List<Item> itemVendidos;
	
	public String getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}
	public List<Item> getItemVendidos() {
		return itemVendidos;
	}
	public void setItemVendidos(List<Item> itemVendidos) {
		this.itemVendidos = itemVendidos;
	}
	
	public static class Factory {
		public static Venda criar(List<String> dados) {
			Venda venda = new Venda();
			venda.setCodigo(Long.valueOf(dados.get(0)));
			venda.setIdVenda(dados.get(1));
			venda.setItemVendidos(FabricaDeItens.fabricarItem(dados.get(2)));
			venda.setNome(dados.get(3));
			return venda;
		}
	}
}
