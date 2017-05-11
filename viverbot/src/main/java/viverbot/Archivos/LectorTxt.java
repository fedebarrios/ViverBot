package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorTxt {
	Validador validador;
	Parser parser;
	
	public LectorTxt(Validador validador, Parser parser){
		this.validador = validador;
		this.parser = parser;
	}
	
	public String leerTxt(String archivo) {
		if(!validador.validarExistencia(archivo)){
			System.out.println("No existe archivo");
			return "N";
		}else if (!validador.validarExtension(archivo, "txt")){
			System.out.println("La extension del archivo no es .txt.");
			return "E";
		}
		String data = "";
        FileReader f;
		try {
			f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        String line = "";
	        while((line = b.readLine()) != null) {
	            data += line + "/";
	        }
	        b.close();
		} catch (IOException e) {
			e.printStackTrace();
			return e.toString();
		}
        return data;
    }
}
