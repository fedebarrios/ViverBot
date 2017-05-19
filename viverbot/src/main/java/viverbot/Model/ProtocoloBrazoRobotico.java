package viverbot.Model;

import java.util.ArrayList;

import viverbot.Controlador.ControladorPuenteBrazoRobotico;
import viverbot.DAO.ColaTareas;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.Tarea;
import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Medicion.AnalizadorCaminoMinimo;

public class ProtocoloBrazoRobotico extends Thread {
//Cuando el sistema se enciende debe comprobar 
//si el brazo está en la ubicación de descanso y 
//colocarlo en ese lugar si es que no se encuentra allí.
	private TerrenoDAO terreno;
	private UbicacionDTO ubicacionActual;
	private AnalizadorCaminoMinimo analizador;
	private ColaTareas listaTareas;
	private boolean estadoBrazo;
	private ControladorPuenteBrazoRobotico controlador;
	
	public ProtocoloBrazoRobotico(){
		terreno = TerrenoDAO.getInstance();
		this.analizador = new AnalizadorCaminoMinimo();
		this.listaTareas = ColaTareas.getInstance();
		this.estadoBrazo = false;
		this.controlador = new ControladorPuenteBrazoRobotico();
	}
	
	public void ejecutarTarea(Tarea tarea){
		ejecutarMovimiento(tarea.mostrarUbicacion());
		tarea.ejecutarTarea();
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
		double auxEjeX = controlador.obtenerDistanciaEjeX();
		double auxEjeY = controlador.obtenerDistanciaEjeY();
		if(auxEjeX<ubicacionDestino.getEjeX()){
			while(auxEjeX<ubicacionDestino.getEjeX()){
				controlador.incrementarEjeX(0.1);
				auxEjeX = controlador.obtenerDistanciaEjeX();
			}
		}
		if(auxEjeX>ubicacionDestino.getEjeX()){
			while(auxEjeX>ubicacionDestino.getEjeX()){
				controlador.decrementarEjeX(0.1);
				auxEjeX = controlador.obtenerDistanciaEjeX();
			}
		}
		if(auxEjeY<ubicacionDestino.getEjeY()){
			while(auxEjeY<ubicacionDestino.getEjeY()){
				controlador.incrementarEjeY(0.1);
				auxEjeY = controlador.obtenerDistanciaEjeY();
			}
		}
		if(auxEjeY>ubicacionDestino.getEjeY()){
			while(auxEjeY>ubicacionDestino.getEjeY()){
				controlador.decrementarEjeY(0.1);
				auxEjeY = controlador.obtenerDistanciaEjeY();
			}
		}
	}
	
	public boolean estaOcupado(){
		return estadoBrazo;
	}
	
	public UbicacionDTO mostrarUbicacionActualDelBrazo(){
		return null;
	}
	
	@Override
	public void run() {
		estadoBrazo=true;
		while(!listaTareas.estaVacia()){
			ejecutarTarea(listaTareas.obtenerTarea());
		}
		estadoBrazo=false;
	}
	
	
	
	
	
	
	
	
	
	
}
