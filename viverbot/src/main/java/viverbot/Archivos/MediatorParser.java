package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

import viverbot.DTO.EspecieDTO;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.TuplaAltura;

public class MediatorParser {
	
	public HistorialOptimo parsearHistorialEspecie(List<String> datos){
		EspecieDTO especie = null;
		List<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		for(String s : datos){
			if(s.substring(0,1).equals("h")){
				ParserHistorial parser = new ParserHistorial();
				tuplas.add(parser.parsearHistorial(s));
			} else{
			    ParserEspecie parser = new ParserEspecie();
			    especie = parser.parsearEspecie(s);
			}
		}
		return new HistorialOptimo(tuplas,especie);
	}
}
