package viverbot.DAO;

import java.util.LinkedList;
import java.util.Queue;
import viverbot.Controlador.ObservadorTareas;
import viverbot.DTO.Tarea;

public class ColaTareas {
	private Queue<Tarea> _tareas;
	private static ColaTareas _listaTareas;
	private ObservadorTareas _observador;
	private int _cantTareasResueltas;
	
	private ColaTareas(){
		_tareas = new LinkedList<Tarea>();
		_observador = new ObservadorTareas(this); 
		_cantTareasResueltas=0;
	}
	
	public void agregarTarea(Tarea tarea){
		_tareas.add(tarea);
		_observador.actualizarEstadoProtocolo();
	}
	
	public boolean estaVacia(){
		return _tareas.isEmpty();
	}
	
	public Tarea obtenerTarea(){
		_cantTareasResueltas++;
		return _tareas.poll();
	}
	
	public int mostrarCantidadDeTareasResueltas(){
		return _cantTareasResueltas;
	}
	
	public void reiniciarContadorTareasResueltas(){
		_cantTareasResueltas=0;
	}
	
	public static ColaTareas getInstance(){
		if(_listaTareas==null){
			_listaTareas = new ColaTareas();
		}
		return _listaTareas;
	}
}
