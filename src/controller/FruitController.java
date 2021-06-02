package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FruitController implements ItcFruit {

	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					// System.out.println(" \t" + f.getName());
				} else {
					// System.out.println("<DIR>\t" + f.getName());
				}
			}
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			System.out.println("FOOD NAME \t SCIENTIFIC NAME \t SUBGROUP");
			while (linha != null) {

				if (linha.contains("Fruits")) {
					String x = linha.split(",")[0];
					String y = linha.split(",")[1];
					String z = linha.split(",")[3];
					System.out.println(x + "\t" + y + "\t" + z);
				} // System.out.println("");

				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

}
