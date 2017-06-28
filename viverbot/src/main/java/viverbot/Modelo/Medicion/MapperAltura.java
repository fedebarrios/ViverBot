package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.Planta;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.Log;
import viverbot.Model.ManagerSeguimientos;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Medicion;

public class MapperAltura extends Observable implements Observer  {
	
	private AnalizadorAltura analizador;
	private List<Planta> plantas;
	private ManagerSeguimientos buscador;
	private List<EstadoAltura> estadosDePlantas;
	private GuardadorAltura guardador;
	
	public MapperAltura(AnalizadorAltura analizador, List<Planta> plantas, ManagerSeguimientos buscador){
		this.analizador = analizador;
		this.plantas = plantas;
		this.buscador = buscador;
		estadosDePlantas = new ArrayList<EstadoAltura>();
	}
	
	public List<EstadoAltura> relacionar(List<Medicion> alturas){
		List<EstadoAltura> estadosDevueltos = new ArrayList<EstadoAltura>(); 
		int i = 0;
		for(Planta p : plantas){
			SeguimientoAltura seguimiento = buscador.getSeguimiento(p);
			int diaActual = seguimiento.getUltimoDiaMedicion()+1;
			Medicion alturaActual = alturas.get(i);
			Medicion alturaIdeal = seguimiento.getHistorialOptimo().buscarMedicion(diaActual);
			if(alturaIdeal instanceof EmptyMedicion){
				Log.getLog(MapperAltura.class).info("No existe altura ideal contra la cual comparar");
			}
			else{
				estadosDevueltos.add(analizador.analizar(alturaActual, alturaIdeal , p));
			}
			//guardador.guardar(alturaActual, diaActual, seguimiento.getHistorialVerdadero());
			i++;
		}
		return estadosDevueltos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object alturasTomadas) {
		this.estadosDePlantas = this.relacionar(((ArrayList<Medicion>) alturasTomadas));
		notificar();
	}
	
	protected void notificar() {
		setChanged();
		notifyObservers(estadosDePlantas);
	}
}
