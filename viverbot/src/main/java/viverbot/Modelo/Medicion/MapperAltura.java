package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.PlantaDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.Altura;

public class MapperAltura extends Observable implements Observer  {
	
	private AnalizadorAltura analizador;
	private List<PlantaDTO> plantas;
	private ControlSeguimientos buscador;
	private List<EstadoAltura> estadosDePlantas;
	
	public MapperAltura(AnalizadorAltura analizador, List<PlantaDTO> plantas, ControlSeguimientos buscador){
		this.analizador = analizador;
		this.plantas = plantas;
		this.buscador = buscador;
		estadosDePlantas = new ArrayList<EstadoAltura>();
	}
	
	public List<EstadoAltura> relacionar(List<Altura> alturas){
		List<EstadoAltura> estadosDevueltos = new ArrayList<EstadoAltura>(); 
		int i = 0;
		for(PlantaDTO p : plantas){
			SeguimientoAltura seguimiento = buscador.getSeguimiento(p);
			int diaActual = seguimiento.getUltimoDiaMedicion()+1;
			estadosDevueltos.add(analizador.analizar(alturas.get(i), seguimiento, diaActual));
			i++;
		}
		return estadosDevueltos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object alturasTomadas) {
		this.estadosDePlantas = this.relacionar(((ArrayList<Altura>) alturasTomadas));
		notificar();
	}
	
	protected void notificar() {
		setChanged();
		notifyObservers(estadosDePlantas);
	}

}
