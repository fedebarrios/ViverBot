package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {

	public String lecturaParcial(BufferedReader b) throws IOException{
		String line = "";
		while ((line = b.readLine()) != null) {
			return line;
		}
		return "";	
	}
	
	public String leerArchivo(String path) throws Exception {
		String data = "";
		FileReader f;
		try {
			f = new FileReader(path);
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
