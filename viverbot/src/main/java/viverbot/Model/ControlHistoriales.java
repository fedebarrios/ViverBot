package viverbot.Model;

import java.util.ArrayList;
import java.util.List;

import viverbot.DTO.Especie;

public class ControlHistoriales {
	protected static ControlHistoriales control;
	private List<HistorialIdeal> historiales;
	
	private ControlHistoriales(){
		this.historiales = new ArrayList<HistorialIdeal>();
	}
	
	public static ControlHistoriales getInstance(){
		if(control == null ){
			control = new ControlHistoriales();
		}
		return control;
	}
	
	public void agregarSeguimiento(HistorialIdeal historial){
		historiales.add(historial);
	}
	
	public void borrarrSeguimiento(HistorialIdeal historial){
		historiales.remove(historial);
	}
	
	public HistorialIdeal getHistorial(Especie especie){
		for(HistorialIdeal h : historiales){
			if(h.getEspecie().equals(especie)){
				return h;
			}
		}
		return null;
	}
	
	public boolean existeHistorial(Especie especie){
		for(HistorialIdeal h : historiales){
			if(h.getEspecie().equals(especie)){
				return true;
			}
		}
		return false;
	}

	public int cantidadHistoriales() {
		return historiales.size();
	}
}