package viverbot.Archivos;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import viverbot.DTO.Especie;
import viverbot.Model.ControlHistoriales;
import viverbot.Model.HistorialIdeal;
import viverbot.Model.Inventario;
import viverbot.Model.Log;

public class MapperCargador implements Observer{
	private ControlHistoriales controlHistoriales;
	private Inventario inventario;

	public MapperCargador(ControlHistoriales control, Inventario inventario){
		this.controlHistoriales = control;
		this.inventario = inventario;
	}
	
	protected boolean sePuedeCargarHistorial(HistorialIdeal h){
		if(!controlHistoriales.existeHistorial(h.getEspecie())){
			return true;
		}
		return false;
	}
	
	protected boolean sePuedeCargarEspecie(Especie especie){
		if(!inventario.existeEspecie(especie)){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object historiales) {
		int i = cargar((List<HistorialIdeal>) historiales);
		Log.getLog(MapperCargador.class).info("Se cargaron "+i+" historiales");
	}

	protected int cargar(List<HistorialIdeal> historiales) {
		int cantidadCargadas= 0;
		for(HistorialIdeal h : historiales){
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
