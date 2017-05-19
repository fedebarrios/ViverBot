package viverbot.DAO;

import java.util.ArrayList;
import viverbot.DTO.TareaDTO;

public class ListaTareas {
	private ArrayList<TareaDTO> tareas;
	private static ListaTareas listaTareas;
	
	private ListaTareas(){
		tareas = new ArrayList<TareaDTO>();
	}
	
	public void agregarTarea(TareaDTO tarea){
		tareas.add(tarea);
	}
	
	public void borrarTarea(TareaDTO tarea){
		tareas.remove(tarea);
	}
	
	public static ListaTareas getInstance(){
		if(listaTareas==null){
			listaTareas = new ListaTareas();
		}
		return listaTareas;
	}
}
