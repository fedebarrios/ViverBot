package viverbot.Archivos;

import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class ParserHistorial extends Parser{
	
	public TuplaAltura parsearHistorial(String s){
		s = s.substring(1);
		String[] datos = s.split(":");
		int dia = Integer.parseInt(datos[0]);
		double altura = Double.parseDouble(datos[1]);
		TuplaAltura t = new TuplaAltura(new Medicion(altura,Magnitudes.ALTURA),dia);
		return t;
	}
	
	
}
