package viverbot.Model;

import viverbot.Controlador.ControladorPuenteBrazoRobotico;
import viverbot.DAO.ColaTareas;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.Tarea;
import viverbot.DTO.UbicacionDTO;

public class ControladorBrazoRobotico extends Thread {
	
	private TerrenoDAO _terreno;
	private ColaTareas _listaTareas;
	private boolean _estadoBrazo;
	private ControladorPuenteBrazoRobotico _controlador;
	private final double _distancia = 0.1;
	private UbicacionDTO _ubicacionActual;
	
	public ControladorBrazoRobotico(ColaTareas listaTareas){
		_terreno = TerrenoDAO.obtenerInstancia();
		_listaTareas = listaTareas;
		_estadoBrazo = false;
		_controlador = new ControladorPuenteBrazoRobotico();
		_ubicacionActual = _terreno.mostrarUbicacionDescanso();
	}
	
	public void inicializarControlador(){
		if(!estaEnPosicionDescanso(mostrarUbicacionActualDelBrazo()))
		{
			moverBrazo(_terreno.mostrarUbicacionDescanso());
		}
		ejecutarTareasPendientes();
	}
	
	public void ejecutarTareasPendientes(){
		run();
	}
	
	@Override
	public void run() {
		_estadoBrazo=true;
		while(!_listaTareas.estaVacia()){
			ejecutarTarea(_listaTareas.obtenerTarea());
		}
		moverBrazo(_terreno.mostrarUbicacionDescanso());
		_estadoBrazo=false;
	}
	
	public void ejecutarTarea(Tarea tarea){
		moverBrazo(tarea.mostrarUbicacion());
		tarea.ejecutarTarea();
	}
	
	public void moverBrazo(UbicacionDTO ubicacionDestino){
		double ejeXActual = _controlador.obtenerDistanciaEjeX();
		double ejeYActual = _controlador.obtenerDistanciaEjeY();
		centrarEjeX(ejeXActual, ubicacionDestino.getEjeX());
		centrarEjeY(ejeYActual, ubicacionDestino.getEjeY());
		_ubicacionActual=ubicacionDestino;
	}
	
	private void centrarEjeX(double ejeXOrigen, double ejeXDestino){
		if(ejeXOrigen<ejeXDestino){
			while(ejeXOrigen<ejeXDestino){
				_controlador.incrementarEjeX(_distancia);
				ejeXOrigen = _controlador.obtenerDistanciaEjeX();
			}
		}
		if(ejeXOrigen>ejeXDestino){
			while(ejeXOrigen>ejeXDestino){
				_controlador.decrementarEjeX(_distancia);
				ejeXOrigen = _controlador.obtenerDistanciaEjeX();
			}
		}
	}
	
	private void centrarEjeY(double EjeYOrigen, double EjeYDestino){
		if(EjeYOrigen<EjeYDestino){
			while(EjeYOrigen<EjeYDestino){
				_controlador.incrementarEjeY(_distancia);
				EjeYOrigen = _controlador.obtenerDistanciaEjeY();
			}
		}
		if(EjeYOrigen>EjeYDestino){
			while(EjeYOrigen>EjeYDestino){
				_controlador.decrementarEjeY(_distancia);
				EjeYOrigen = _controlador.obtenerDistanciaEjeY();
			}
		}
	}
	
	public boolean estaOcupado(){
		return _estadoBrazo;
	}
	
	public boolean estaEnPosicionDescanso(UbicacionDTO ubicacion){
		return _terreno.mostrarUbicacionDescanso().equals(ubicacion);
	}
	
	public UbicacionDTO mostrarUbicacionActualDelBrazo(){
		_ubicacionActual.setEjeX(_controlador.obtenerDistanciaEjeX());
		_ubicacionActual.setEjeY(_controlador.obtenerDistanciaEjeY());
		return _ubicacionActual;
	}
}
