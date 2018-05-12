package br.com.prova.filereaderengine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import br.com.prova.filereaderengine.domain.Cliente;
import br.com.prova.filereaderengine.domain.Item;
import br.com.prova.filereaderengine.domain.Venda;
import br.com.prova.filereaderengine.domain.Vendedor;

public class GeradorRelatorio {
	
	private static final String TRACO = "-";
	
	public static void gerarRelatorio(List<Cliente> clientes, List<Venda> vendas, List<Vendedor> vendedores) {

		BufferedWriter bw = null;
		FileOutputStream fos = null;
		
		try {
			Long numClientes = Long.valueOf(clientes.size());
			Long numVendedores = Long.valueOf(vendedores.size());
			String vendaMaisCara = verificarVendaMaisCara(vendas);
			String piorVendedor = verificarPiorVendedor(vendas);

			File file = new File(System.getProperty("user.home") + "/data/out/relatorio.done.dat");
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("Quantidade de clientes no arquivo de entrada: " + numClientes);
			bw.newLine();
			bw.write("Quantidade de vendedor no arquivo de entrada: " + numVendedores);
			bw.newLine();
			bw.write("ID da venda mais cara: " + vendaMaisCara);
			bw.newLine();
			bw.write("O pior vendedor: " + piorVendedor);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fos != null)
					fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
	}

	private static String verificarPiorVendedor(List<Venda> vendas) {
		String piorVendedor = null;
		BigDecimal menorValor = null;
		if(CollectionUtils.isNotEmpty(vendas)) {
			for (Venda venda : vendas) {
				BigDecimal valorDaVenda = BigDecimal.ZERO;
				for (Item item : venda.getItemVendidos()) {
					valorDaVenda = valorDaVenda.add(item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
				}
				System.out.println(venda.getNome()+":"+valorDaVenda);
				if (menorValor == null) {
					menorValor = valorDaVenda;
					piorVendedor = venda.getNome();
				} else if (valorDaVenda.compareTo(menorValor) < 0) {
					piorVendedor = venda.getNome();
					menorValor = valorDaVenda;
				}
			}
		} else {
			piorVendedor = TRACO;
		}
		return piorVendedor;
	}

	private static String verificarVendaMaisCara(List<Venda> vendas) {
		String idVendaMaisCara = null;
		BigDecimal maiorValor = BigDecimal.ZERO;
		if(CollectionUtils.isNotEmpty(vendas)) {
			for (Venda venda : vendas) {
				BigDecimal valorDaVenda = BigDecimal.ZERO;
				for (Item item : venda.getItemVendidos()) {
					valorDaVenda = valorDaVenda.add(item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
				}
				System.out.println(venda.getIdVenda()+":"+valorDaVenda);
				if (valorDaVenda.compareTo(maiorValor) > 0) {
					idVendaMaisCara = venda.getIdVenda();
					maiorValor = valorDaVenda;
				}
			}
		} else {
			idVendaMaisCara = TRACO;
		}
		return idVendaMaisCara;
	}
}
