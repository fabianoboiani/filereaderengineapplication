package br.com.prova.filereaderengine.domain;

import java.math.BigDecimal;
import java.util.List;

public class Item {
	private Long itemId;
	private Long quantidade;
	private BigDecimal preco;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	public static class Factory {
		public static Item criar(List<String> dados) {
			Item item = new Item();
			item.setItemId(Long.valueOf(dados.get(0)));
			item.setQuantidade(Long.valueOf(dados.get(1)));
			item.setPreco(new BigDecimal(dados.get(2)));
			return item;
		}
	}
}
