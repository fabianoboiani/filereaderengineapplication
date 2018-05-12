package br.com.prova.filereaderengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;

import br.com.prova.filereaderengine.domain.Cliente;
import br.com.prova.filereaderengine.domain.TipoDado;
import br.com.prova.filereaderengine.domain.Venda;
import br.com.prova.filereaderengine.domain.Vendedor;

public class Executor {

	private static final String EXTENSAO = "dat";
	
	@SuppressWarnings("unchecked")
	public static void run() {

		BufferedReader br = null;
		FileReader fr = null;
		
		List<Cliente> clientes = new ArrayList<>();
		List<Vendedor> vendedores = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();

		try {
			File dir = new File(System.getProperty("user.home") + "/data/in");
			List<File> files = (List<File>) FileUtils.listFiles(dir,  new String[] {EXTENSAO}, true);
			for (File file : files) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					List<String> dados = Arrays.asList(sCurrentLine.split("ç"));
					if(CollectionUtils.isNotEmpty(dados)) {
						if(TipoDado.CLIENTE.getCodigo().equals(dados.get(0))) {
							clientes.add(Cliente.Factory.criar(dados));
						} else if(TipoDado.VENDA.getCodigo().equals(dados.get(0))) {
							vendas.add(Venda.Factory.criar(dados));
						} else if (TipoDado.VENDEDOR.getCodigo().equals(dados.get(0))) {
							vendedores.add(Vendedor.Factory.criar(dados));
						}
					}
				}
			}
			GeradorRelatorio.gerarRelatorio(clientes, vendas, vendedores);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
