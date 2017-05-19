package viverbot.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import viverbot.Archivos.LectorTxt;
import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.SelectorEstadosPorValor;
import viverbot.DTO.PlantaDTO;

public class BuscadorEstadoAltura {
	private Map<Integer, SelectorEstadosPorValor> map;
	private static BuscadorEstadoAltura buscador;
	private Logger logger;
	
	public BuscadorEstadoAltura(){
		this.setMap(new HashMap<Integer, SelectorEstadosPorValor>());
		logger = Log.getLog(LectorTxt.class);
	};
	
	public static BuscadorEstadoAltura getInstance(){
		if(buscador == null ){
			buscador = new BuscadorEstadoAltura();
		}
		return buscador;
	}
	
	public void cleanMap() {
		BuscadorEstadoAltura.getInstance().setMap(new HashMap<Integer, SelectorEstadosPorValor>());
	}
	
	public EstadoAltura obtenerEstadoPorEspecie(double valorCrecimiento, double diferenciaAltura , PlantaDTO planta){
		SelectorEstadosPorValor tupla = map.get(planta.getCodigo());
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

	public Map<Integer, SelectorEstadosPorValor> getMap() {
		return map;
	}

	public void setMap(Map<Integer, SelectorEstadosPorValor> map) {
		this.map = map;
	}
	
	public void agregarEntrada(SelectorEstadosPorValor tupla, Integer codigoEspecie){
		this.map.put(codigoEspecie, tupla);
	}
}
