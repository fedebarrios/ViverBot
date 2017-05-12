package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

import viverbot.Controlador.Verificacion.EstadoAltura;
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
				tuplas.add(parser.parsear(s));
			} else{
			    ParserEspecie parser = new ParserEspecie();
			    especie = parser.parsear(s);
			}
		}
		return new HistorialOptimo(tuplas,especie);
	}
	
	public List<EstadoAltura> parsearEstados(List<String[]> datos){
		List<EstadoAltura> estados = new ArrayList<EstadoAltura>();
		ParserEstados parser = new ParserEstados();
		for(int i = 0; i < datos.get(1).length; i++){
			if (i == 0){
				estados.add(parser.parsear(datos.get(1)[i], -1, Integer.parseInt(datos.get(0)[i])));
			}
			else if (i == datos.get(1).length - 1){
				estados.add(parser.parsear(datos.get(1)[i - 1], Integer.parseInt(datos.get(0)[i - 2]), -1));
			}
			else{
				estados.add(parser.parsear(datos.get(1)[i], Integer.parseInt(datos.get(0)[i - 1]), Integer.parseInt(datos.get(0)[i])));
			}
		}
		return estados;
	}
}
