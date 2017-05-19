package viverbot;

import java.util.ArrayList;
import viverbot.DAO.ColaTareas;
import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.TareaMedirAltura;
import viverbot.DTO.TareaMedirHumedad;
import viverbot.DTO.TareaRegarUbicacion;
import viverbot.DTO.UbicacionDTO;

public class GeneradorTareas extends Thread{
	private ColaTareas _colaTareas;
	private int _cantColumnas;
	private int _cantFilas;
	private ArrayList<UbicacionDTO> _ubicaciones;
	private TerrenoDAO _terreno;

	public GeneradorTareas() {
		_terreno = TerrenoDAO.obtenerInstancia();
		_colaTareas = ColaTareas.getInstance();
		this._cantColumnas = _terreno.mostrarCantidadColumnas();
		this._cantFilas = _terreno.mostrarCantidadFilas();
		_ubicaciones = _terreno.mostrarListaUbicaciones();	
	}
	
	public void generarTareas() {
		run();
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(500);
			generarTareasMedirHumedad();
			Thread.sleep(500);
			generarTareasMedirAltura();
			Thread.sleep(500);
			generarTareasRegar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UbicacionDTO> generarUbicaciones(int cantFilas, int cantColumnas){
		ArrayList<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
		int indice=0;
		double ejeX;
		double ejeY;
		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				ejeX = (i+1)/2;
				ejeY = (j+1)/2;
				UbicacionDTO aux = new UbicacionDTO(i,j,indice);
				aux.setEjeX(ejeX);
				aux.setEjeY(ejeY);
				ubicaciones.add(aux);
				indice++;
			}
		}
		return ubicaciones;
	}
	
	public int generarTareasMedirHumedad() {
		int cantTareas = _cantColumnas*_cantFilas;
		for (int i = 0; i < cantTareas; i++) {
			_colaTareas.agregarTarea(new TareaMedirHumedad(_ubicaciones.get(i)));
		}
		return cantTareas;
	}

	public int generarTareasMedirAltura() {
		int cantTareas = _cantColumnas*_cantFilas;
		for (int i = 0; i < cantTareas; i++) {
			_colaTareas.agregarTarea(new TareaMedirAltura(_ubicaciones.get(i)));
		}
		return cantTareas;
	}

	public int generarTareasRegar() {
		int cantTareas = _cantColumnas*_cantFilas;
		for (int i = 0; i < cantTareas; i++) {
			_colaTareas.agregarTarea(new TareaRegarUbicacion(_ubicaciones.get(i)));
		}
		return cantTareas;
	}
}
