package viverbot.Model;

import java.util.ArrayList;
import java.util.List;

import viverbot.DTO.EspecieDTO;

public class ControlHistoriales {
	protected static ControlHistoriales control;
	private List<HistorialOptimo> historiales;
	
	private ControlHistoriales(){
		this.historiales = new ArrayList<HistorialOptimo>();
	}
	
	public static ControlHistoriales getInstance(){
		if(control == null ){
			control = new ControlHistoriales();
		}
		return control;
	}
	
	public void agregarSeguimiento(HistorialOptimo historial){
		historiales.add(historial);
	}
	
	public void borrarrSeguimiento(HistorialOptimo historial){
		historiales.remove(historial);
	}
	
	public HistorialOptimo getHistorial(EspecieDTO especie){
		for(HistorialOptimo h : historiales){
			if(h.equals(especie)){
				return h;
			}
		}
		return null;
	}
	
	public boolean existeHistorial(EspecieDTO especie){
		for(HistorialOptimo h : historiales){
			if(h.equals(especie)){
				return true;
			}
		}
		return false;
	}

	public int cantidadHistoriales() {
		return historiales.size();
	}
}