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
	        List<String> entradas = new ArrayList<String>();
	        List<String[]> arreglos = new ArrayList<String[]>();
	        entradas = Separador.separarEntradas(data);
	        if (entradas.size() == 1 || entradas.size() == 2){
	        	logger.info("El archivo debe contener 3 renglones.");
	        	return null;
	        }
	        arreglos.add(entradas.get(0).split(","));
	        arreglos.add(entradas.get(1).split(","));
	        String[] codigo = {entradas.get(2)};
	        arreglos.add(codigo);
	        return arreglos;
	  
		}
		catch(Exception e){
			Log.getLog(LectorEstados.class).error(e.getMessage());
		}
		return null;
	}

}
