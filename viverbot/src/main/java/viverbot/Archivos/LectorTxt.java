package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorTxt {
	Validador validador;
	
	public LectorTxt(Validador validador){
		this.validador = validador;
	}
	
	public String leerTxt(String archivo) {
		if(!validador.validarExistencia(archivo)){
			System.out.println("No existe archivo");
			return null;
		}else if (!validador.validarExtension(archivo, "txt")){
			System.out.println("La extension del archivo no es .txt.");
			return null;
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
