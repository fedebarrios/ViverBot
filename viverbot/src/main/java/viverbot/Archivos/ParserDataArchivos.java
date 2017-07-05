package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

import viverbot.DTO.Especie;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Model.HistorialAltura;
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

	public ArrayList<EstadoAltura> parsearEstados(String lectura){
		Pattern p = Pattern.compile("Estados:\\(([A-Za-z,]+)\\)");
		Matcher m = p.matcher(lectura);
		String match = "";
		while(m.find()) {
			match += m.group(1);
		}
		ArrayList<EstadoAltura> estados = new ArrayList<EstadoAltura>();
		if (match.equals("")){
			logger.error("Los estados tienen caracteres no alfanumericos o no estan seteados.");
			return estados;
		}
		String[] estadosJuntados = match.split(",");
		for(int i = 0; i < estadosJuntados.length; i++){
			EstadoAltura estado = new EstadoAltura();
			estado.setEstado(estadosJuntados[i]);
			estados.add(estado);
		}
		return estados;
	}
	
	public ArrayList<Double> parsearValores(String lectura) throws Exception{	
		Pattern p = Pattern.compile("Valores:\\(([0-9,]+)\\)");
		Matcher m = p.matcher(lectura);
		String match = "";
		while(m.find()) {
			match += m.group(1);
		}
		ArrayList<Double> valores = new ArrayList<Double>();
		if (match.equals("")){
			logger.error("Los valores no son alfanumericos o no estan seteados.");
			return valores;
		}
		String[] valoresJuntados = match.split(",");
		for(int i = 0; i < valoresJuntados.length; i++){
			valores.add(Double.valueOf(valoresJuntados[i]));
		}
		return valores;
	}
	
	public String parsearCodigoEspecie(String lectura) throws Exception{
		Pattern p = Pattern.compile("Codigo:\\(([0-9]+)\\)");
		Matcher m = p.matcher(lectura);
		String valor = "";
		while(m.find()) {
			valor = m.group(1);
		}
		if (valor.equals("")){
			logger.error("El codigo no es numerico o no esta seteado.");
			return "";
		}
		return valor;
	}
}
