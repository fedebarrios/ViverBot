package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.TuplaEstadosValores;
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
	
	public TuplaEstadosValores parsearEstadosValores(List<String[]> datos){
		List<EstadoAltura> estados = new ArrayList<EstadoAltura>();
		List<Integer> valores = new ArrayList<Integer>();
		ParserEstados parser = new ParserEstados();
		for(int i = 0; i < datos.get(0).length; i++){
			valores.add(Integer.valueOf(datos.get(0)[i]));
		}
		for(int i = 0; i < datos.get(1).length; i++){
			estados.add(parser.parsear(datos.get(1)[i]));
		}
		return new TuplaEstadosValores(estados, valores);
	}
	
	public Integer parsearCodigoEspecie(List<String[]> datos){
		ParserEstados parser = new ParserEstados();
		Integer valor = parser.getCodigoEspecie(datos.get(2));
		return valor;
	}
}
