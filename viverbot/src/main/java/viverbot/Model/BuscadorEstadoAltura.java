package viverbot.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import viverbot.Archivos.LectorArchivo;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadosDeAlturaDisponibles;
import viverbot.DTO.Planta;

public class BuscadorEstadoAltura {
	private Map<String, EstadosDeAlturaDisponibles> map;
	private static BuscadorEstadoAltura buscador;
	private Logger logger;
	
	public BuscadorEstadoAltura(){
		this.setMap(new HashMap<String, EstadosDeAlturaDisponibles>());
		logger = Log.getLog(LectorArchivo.class);
	};
	
	public static BuscadorEstadoAltura getInstance(){
		if(buscador == null ){
			buscador = new BuscadorEstadoAltura();
		}
		return buscador;
	}
	
	public void cleanMap() {
		BuscadorEstadoAltura.getInstance().setMap(new HashMap<String, EstadosDeAlturaDisponibles>());
	}
	
	public EstadoAltura obtenerEstadoPorEspecie(double valorCrecimiento, double diferenciaAltura , Planta planta){
		EstadosDeAlturaDisponibles tupla = map.get(planta.getNombreEspecie());
		if (tupla == null){
			logger.error("No existe un selector para la especie dada.");
			return null;
		}
		ArrayList<EstadoAltura> estados = tupla.getEstados();
		ArrayList<Double> valores = tupla.getValores();
		int i = 0;
		for (EstadoAltura estado : estados){
			if ((  i == 0 && valorCrecimiento <= valores.get(0))
			   ||( i == estados.size() - 1 && valorCrecimiento > valores.get(i - 1))
			   ||( i != 0 && i != estados.size() - 1 && valorCrecimiento > valores.get(i - 1) && valorCrecimiento <= valores.get(i))){ 
				estado.setCmDeDiferencia(diferenciaAltura);
				estado.setPlanta(planta);
				return estado;
			}
			i++;
		}
		return null;
	}
	
	public boolean existeEspecie(String especie){
		EstadosDeAlturaDisponibles tupla = map.get(especie);
		if (tupla != null){
			return true;
		}
		return false;
	}

	public Map<String, EstadosDeAlturaDisponibles> getMap() {
		return map;
	}

	public void setMap(Map<String, EstadosDeAlturaDisponibles> map) {
		this.map = map;
	}
	
	public void agregarEntrada(EstadosDeAlturaDisponibles tupla, String nombreEspecie){
		this.map.put(nombreEspecie, tupla);
	}
}
