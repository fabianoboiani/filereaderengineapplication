package br.com.prova.filereaderengine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.prova.filereaderengine.domain.Item;

public class FabricaDeItens {

	public static List<Item> fabricarItem(String dados) {
		List<String> itensNaoAjustados = Arrays.asList(StringUtils.substring(dados, 1, dados.length()-1).split(","));
		List<Item> itens = new ArrayList<>();
		for (String item : itensNaoAjustados) {
			itens.add(Item.Factory.criar(Arrays.asList(item.split(("-")))));
		}
		return itens;
	}
}
