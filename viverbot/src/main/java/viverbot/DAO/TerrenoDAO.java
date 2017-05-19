package viverbot.DAO;

import java.util.ArrayList;

import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Magnitudes.Temperatura;

public class TerrenoDAO {

	private UbicacionDTO[][] _ubicaciones;
	private static TerrenoDAO _terreno;
	private static Temperatura _temperatura;
	private int _cantFilas;
	private int _cantColumnas;
	
	private TerrenoDAO(){
		_cantFilas=0;
		_cantColumnas=0;
		_ubicaciones = new UbicacionDTO[0][0];
	}
	
	public void construirTerreno(int cantFilas, int cantColumnas) {
		_cantColumnas = cantColumnas;
		_cantFilas = cantFilas;
		_ubicaciones = generarMatrizIrregularTerreno(cantFilas, cantColumnas);
		generarUbicacionesDentroDelTerreno(_ubicaciones);
	}

	private UbicacionDTO[][] generarMatrizIrregularTerreno(int cantFilas, int cantColumnas) {
		_ubicaciones = new UbicacionDTO[cantFilas][];
		for (int i = 0; i < cantFilas; i++) {
			if (i == 0) {
				_ubicaciones[i] = new UbicacionDTO[cantColumnas + 1];
				continue;
			}
			_ubicaciones[i] = new UbicacionDTO[cantColumnas];
		}
		generarUbicacionDeDescanso(_ubicaciones);
		return _ubicaciones;
	}
	
	private void generarUbicacionDeDescanso(UbicacionDTO[][] ubicaciones){
		int indicePosicionDescanso = obtenerTamañoTerreno() - 1;
		ubicaciones[0][_cantColumnas] = new UbicacionDTO(0, _cantColumnas, indicePosicionDescanso);
	}
	
	private void generarUbicacionesDentroDelTerreno(UbicacionDTO[][] ubicaciones){
		int indice = 0;
		for (int i = 0; i < _cantFilas; i++) {
			for (int j = 0; j < _cantColumnas; j++) {
				UbicacionDTO ubicacion = new UbicacionDTO(i,j,indice);
				ubicacion.setEjeX((i+1)/2);
				ubicacion.setEjeY((j+1)/2);
				ubicaciones[i][j] = ubicacion;
				indice++;
			}
		}
	}

	public boolean ocuparUbicacion(UbicacionDTO ubicacion) {
		int fila = ubicacion.getFila();
		int columna = ubicacion.getColumna();
		if (!_ubicaciones[fila][columna].isEstado()) {
			_ubicaciones[fila][columna].setEstado(true);
			return true;
		} else
			return false;
	}

	public boolean desocuparUbicacion(UbicacionDTO ubicacion) {
		int fila = ubicacion.getFila();
		int columna = ubicacion.getColumna();
		if (_ubicaciones[fila][columna].isEstado()) {
			_ubicaciones[fila][columna].setEstado(false);
			return true;
		} else
			return false;
	}

	public Integer obtenerTamañoTerreno() {
		//El tamaño del terreno es la multiplicacion de las filas por las columnas mas la posicion de descanso
		return (_cantFilas*_cantColumnas)+1;
	}

	public ArrayList<UbicacionDTO> mostrarListaUbicaciones() {
		ArrayList<UbicacionDTO> listaUbicaciones = new ArrayList<UbicacionDTO>();
		for (int i = 0; i < _ubicaciones.length; i++) {
			for (int j = 0; j < _ubicaciones.length; j++) {
				listaUbicaciones.add(_ubicaciones[i][j]);
			}
		}
		return listaUbicaciones;
	}

	public int mostrarCantidadFilas() {
		return this._cantFilas;
	}

	public int mostrarCantidadColumnas() {
		return this._cantColumnas;
	}

	public UbicacionDTO[][] mostrarMatrizDeUbicaciones() {
		return _ubicaciones;
	}

	public UbicacionDTO mostrarUbicacionDescanso() {
		int primerFila = 0;
		int columnaDescanso = _ubicaciones[primerFila].length -1;
		return _ubicaciones[primerFila][columnaDescanso];
	}

	public static void setTemperatura(Temperatura t) {
		_temperatura = t;
	}

	public static TerrenoDAO obtenerInstancia() {
		if (_terreno == null) {
			_terreno = new TerrenoDAO();
		}
		return _terreno;
	}
}
