package viverbot.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.TuplaEstadosValores;
import viverbot.DTO.PlantaDTO;

public class BuscadorEstadoAltura {
	private Map<Integer, TuplaEstadosValores> map;
	private static BuscadorEstadoAltura buscador;
	
	public BuscadorEstadoAltura(){
		this.setMap(new HashMap<Integer, TuplaEstadosValores>());
	};
	
	public static BuscadorEstadoAltura getInstance(){
		if(buscador == null ){
			buscador = new BuscadorEstadoAltura();
		}
		return buscador;
	}
	
	public EstadoAltura obtenerEstadoPorEspecie(double valorCrecimiento, double diferenciaAltura , PlantaDTO planta){
		TuplaEstadosValores tupla = map.get(planta.getCodigo());
		if (tupla == null){
			return null;
		}
		ArrayList<EstadoAltura> estados = (ArrayList<EstadoAltura>) tupla.getEstados();
		ArrayList<Integer> valores = (ArrayList<Integer>) tupla.getValores();
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

	public Map<Integer, TuplaEstadosValores> getMap() {
		return map;
	}

	public void setMap(Map<Integer, TuplaEstadosValores> map) {
		this.map = map;
	}
	
	public void agregarEntrada(TuplaEstadosValores tupla, Integer codigoEspecie){
		this.map.put(codigoEspecie, tupla);
	}
}
