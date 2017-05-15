package viverbot.Archivos;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import viverbot.DTO.EspecieDTO;
import viverbot.Model.ControlHistoriales;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Inventario;
import viverbot.Model.Log;

public class MapperCargador implements Observer{
	private ControlHistoriales controlHistoriales;
	private Inventario inventario;

	public MapperCargador(){
		controlHistoriales = ControlHistoriales.getInstance();
		inventario = new Inventario();
	}
	
	protected boolean sePuedeCargarHistorial(HistorialOptimo h){
		if(!controlHistoriales.existeHistorial(h.getEspecie())){
			return true;
		}
		return false;
	}
	
	protected boolean sePuedeCargarEspecie(EspecieDTO especie){
		if(!inventario.existeEspecie(especie)){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object historiales) {
		int i = cargar((List<HistorialOptimo>) historiales);
		Log.getLog(MapperCargador.class).info("Se cargaron "+i+" historiales");
	}

	private int cargar(List<HistorialOptimo> historiales) {
		int cantidadCargadas= 0;
		for(HistorialOptimo h : historiales){
			if(sePuedeCargarEspecie(h.getEspecie())&&sePuedeCargarHistorial(h)){
				controlHistoriales.agregarSeguimiento(h);
				String nombre = h.getEspecie().getNombre();
				String nombreCientifico = h.getEspecie().getNombreCientifico();
				String urlImage = h.getEspecie().getUrlImage();
				inventario.agregarEspecie(nombre, nombreCientifico, urlImage);
				cantidadCargadas++;
			}
		}
		return cantidadCargadas;
	}

}
