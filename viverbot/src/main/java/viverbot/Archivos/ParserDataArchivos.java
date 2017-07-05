package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

import viverbot.DTO.Especie;
import viverbot.Model.HistorialIdeal;
import viverbot.Model.Log;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Medicion;

public class ParserDataArchivos {
	protected Logger logger;
	private LectorArchivo lector;
	public ParserDataArchivos(){
		lector = new LectorArchivo();
		logger = Log.getLog(LectorArchivo.class);
	}
	
	public HistorialIdeal parsearHistorialEspecie(String path) throws Exception{
		try{
			List<RegistroHistorial> tuplas = new ArrayList<RegistroHistorial>();	
			Especie especie = null;
			BufferedReader b = new BufferedReader(new FileReader(path));
			String s;
			boolean finalizoNavegacion = false;
			HashMap<Integer,Medicion> mapa = new HashMap<Integer,Medicion>(); 
			while(!finalizoNavegacion){
				s = lector.lecturaParcial(b);
				if(ParserHistorial.parsearTuplaAltura(s)!=null){
					RegistroHistorial registro = ParserHistorial.parsearTuplaAltura(s);
					mapa.put(registro.getDiaDeVida(), registro.getAltura());
				} else if (ParserEspecie.parsearEspecie(s)!=null){
					especie = ParserEspecie.parsearEspecie(s);
				}
				if(s.equals("")) finalizoNavegacion = true;			
			}
			return new HistorialIdeal(mapa,especie);
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}		
	}
	
}
