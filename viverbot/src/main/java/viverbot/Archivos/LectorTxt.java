package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.Verificador;
import viverbot.Model.Log;

public class LectorTxt {
	private Logger logger ;
	
	public LectorTxt(){
		logger = Log.getLog(LectorTxt.class);
	}
	
	public String leerTxt(String archivo) {
		if(!Verificador.validarExistencia(archivo)){
			logger.error("No existe archivo");
			return "N";
		}else if (!Verificador.validarExtension(archivo, ".txt")){
			logger.error("La extension del archivo no es .txt.");
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
