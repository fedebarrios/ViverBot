package viverbot.Model;

import java.util.ArrayList;

import viverbot.DAO.ListaTareas;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.TareaDTO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Medicion.AnalizadorCaminoMinimo;

public class ProtocoloBrazoRobotico {
//Cuando el sistema se enciende debe comprobar 
//si el brazo está en la ubicación de descanso y 
//colocarlo en ese lugar si es que no se encuentra allí.
	private TerrenoDAO terreno;
	private UbicacionDTO ubicacionActual;
	private AnalizadorCaminoMinimo analizador;
	private ListaTareas listaTareas;
	
	public ProtocoloBrazoRobotico(){
		terreno = TerrenoDAO.getInstance();
		this.analizador = new AnalizadorCaminoMinimo();
		this.listaTareas = ListaTareas.getInstance();
	}
	
	public void ejecutarTarea(TareaDTO tarea){
		ejecutarMovimiento(tarea.mostrarUbicacion());
		tarea.ejecutarTarea();
		listaTareas.borrarTarea(tarea);
	}
	
	public boolean estaEnPosicionDescanso(UbicacionDTO ubicacion){
		return terreno.mostrarUbicacionDescanso().equals(ubicacion);
	}
	
	public void ejecutarMovimiento(UbicacionDTO ubicacionDestino){
		int indiceOrigen = ubicacionActual.getIndice();
		int indiceDestino = ubicacionDestino.getIndice();
		ArrayList<UbicacionDTO> recorrido = analizador.caminoMinimo(indiceOrigen, indiceDestino);
		for (UbicacionDTO ubicacion : recorrido) {
			moverBrazo(ubicacion);
		}
	}
	
	public void moverBrazo(UbicacionDTO ubicacionDestino){
		
	}
	
	public boolean estaOcupado(){
		return true;
	}
	
	public UbicacionDTO mostrarUbicacionActualDelBrazo(){
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
