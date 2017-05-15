package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

import viverbot.Model.Log;

public class LectorEstados extends LectorTxt {
	
	public LectorEstados() {
		super();
	}

	public List<String[]> leerArchivo(String archivo) throws Exception{
		try{

	        String data = leerTxt(archivo);
	        if (data.equals("N") || data.equals("E")){
	        	return null;
	        }
	        List<String> entradas = new ArrayList<String>();
	        List<String[]> arreglos = new ArrayList<String[]>();
	        entradas = Separador.separarEntradas(data);
	        arreglos.add(entradas.get(0).split(","));
	        arreglos.add(entradas.get(1).split(","));
	        return arreglos;
	  
		}
		catch(Exception e){
			Log.getLog(LectorEstados.class).error(e.getMessage());
		}
		return null;
	}

}
