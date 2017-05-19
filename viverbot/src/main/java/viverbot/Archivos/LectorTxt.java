package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.Verificador;
import viverbot.Model.Log;

public class LectorTxt {
	protected Logger logger;

	public LectorTxt() {
		logger = Log.getLog(LectorTxt.class);
	}

	public String leerTxt(String archivo) throws Exception {
		if (!Verificador.validarExistencia(archivo)) {
			throw new Exception("No existe archivo.");
		} else if (!Verificador.validarExtension(archivo, ".txt")) {
			throw new Exception("La extension del archivo no es .txt.");
		}
		String data = "";
		FileReader f;
		try {
			f = new FileReader(archivo);
			BufferedReader b = new BufferedReader(f);
			String line = "";
			while ((line = b.readLine()) != null) {
				data += line;
			}
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
			return e.toString();
		}
		return data;
	}
}
