package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import viverbot.Controlador.Verificacion.Verificador;

public class LectorTxt {
	
	public LectorTxt(){
	}
	
	public String leerTxt(String archivo) {
		if(!Verificador.validarExistencia(archivo)){
			System.out.println("No existe archivo.");
			return "N";
		}else if (!Verificador.validarExtension(archivo, ".txt")){
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
