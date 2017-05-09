package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorTxt {
	
	public static String leerTxt(String archivo) {
		if (!archivo.endsWith(".txt")){
			System.out.println("El formato del archivo no es .txt.");
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
