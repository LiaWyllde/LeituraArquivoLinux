package view;

import controller.LeituraController;

public class ArquivoFrutas {
	
    public static void main(String[] args) {

    	LeituraController arquivo = new LeituraController();
        
        //desenvolvido em SO Linux, o diretorio root é representado por "/"
        
		String directory = "/tmp";
		String path = "/tmp";
		String nome = "generic_food.csv";
		
		try {
			arquivo.readDirectory(directory);
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			arquivo.readFile(path, nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
