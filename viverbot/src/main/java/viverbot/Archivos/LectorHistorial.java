package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

public class LectorHistorial extends LectorTxt{

	public LectorHistorial(Validador validador, Parser parser) {
		super(validador, parser);
	}
	
	public List<String> leerArchivo(String path){
		String contenido =this.leerTxt(path);
		List<String> entradas = new ArrayList<String>();
		if(!contenido.equals("N")||!contenido.equals("E")){
			entradas = parser.separarEntradas(contenido);
		}
		return entradas;
	}
		
}
