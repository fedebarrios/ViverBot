package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

public class LectorHistorial extends LectorTxt{

	public LectorHistorial() {
		super();
	}
	
	public List<String> leerArchivo(String path) throws Exception{
		String contenido =this.leerTxt(path);
		List<String> entradas = new ArrayList<String>();
		if( !contenido.equals("N") || !contenido.equals("E")){
			entradas = Separador.separarEntradas(contenido);
		}
		for(String s:entradas) System.out.println(s);
		return entradas;
	}		
}