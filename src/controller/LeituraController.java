package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeituraController {

    public void readDirectory(String path) throws Exception {
    	File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			
			for(File f : files) {
				if (f.isFile()) {
					if (f.getName().equals("generic_food.csv")) {
						System.out.println("\nArquivo encontrado, exibindo... \n");
					}
				}
			}
		} else {
			throw new Exception("Esse diretório não existe.");
		}
    }

    public void readFile(String path, String nome) throws Exception {
        File arquivo = new File(path, nome);
		if(arquivo.exists() && !arquivo.isDirectory()) {
			
			FileInputStream respostas = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(respostas);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			System.out.printf("%-20s %-25s %-20s%n", "FOOD NAME", "SCIENTIFIC NAME", "SUBGROUP");
	        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
	        while(linha != null) {
				if(linha.contains("Tropical fruits")) {
					String[] coluna = linha.split(",");
					if (coluna.length >= 3) {
	                    String nomeFrutinha = coluna[0].trim();
	                    String nomeCientifico = coluna[1].trim();
	                    String grupo = coluna[2].trim();

	                    System.out.printf("%-20s %-25s %-20s%n", nomeFrutinha, nomeCientifico, grupo);
	                }
				}
				linha = buffer.readLine();
			}
	        
			buffer.close();
			leitor.close();
			respostas.close();	
			
		} else {
			throw new Exception("Arquivo não existe");
		}
    }
}
