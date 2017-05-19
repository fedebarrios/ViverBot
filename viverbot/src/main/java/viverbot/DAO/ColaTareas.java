package viverbot.DAO;

import java.util.LinkedList;
import java.util.Queue;

import viverbot.Controlador.ObservadorTareas;
import viverbot.DTO.Tarea;

public class ColaTareas {
	private Queue<Tarea> tareas;
	private static ColaTareas listaTareas;
	private ObservadorTareas observador;
	private ColaTareas(){
		tareas = new LinkedList<Tarea>();
		observador = new ObservadorTareas();
	}
	
	public void agregarTarea(Tarea tarea){
		tareas.add(tarea);
		observador.actualizarEstadoProtocolo();
	}
	
	public boolean estaVacia(){
		return tareas.isEmpty();
	}
	
	public Tarea obtenerTarea(){
		return tareas.poll();
	}
	
	public static ColaTareas getInstance(){
		if(listaTareas==null){
			listaTareas = new ColaTareas();
		}
		return listaTareas;
	}
}
