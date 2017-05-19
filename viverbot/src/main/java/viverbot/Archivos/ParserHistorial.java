package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import viverbot.Interfaces.IParser;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class ParserHistorial implements IParser<List<TuplaAltura>>{
	
	public List<TuplaAltura> parsear(String s) throws Exception{
		Pattern p = Pattern.compile("Dia:\\(([0-9]+[:][0-9]+[.][0-9]+)cm\\)");
		Matcher m = p.matcher(s);
		List<TuplaAltura> historial = new ArrayList<TuplaAltura>();
		List<String> match = new ArrayList<String>();
		while(m.find()) {
			match.add(m.group(1));
		}
		if (match.size()==0){
			throw new Exception("No existe informacion valida acerca del historial");
		}
		for(String tupla : match){
			String[] datosTupla = tupla.split(":");
			int dia = Integer.parseInt(datosTupla[0]);
			double altura = Double.parseDouble(datosTupla[1]);
			historial.add(new TuplaAltura(new Medicion(altura,Magnitudes.ALTURA),dia));
		}
		return historial;
	}
	
	
}
