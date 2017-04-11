package com.losameos.viverbot.DAO;

import com.losameos.viverbot.DTO.UbicacionDTO;

public class TerrenoDAO {
	
	private UbicacionDTO[][] ubicaciones;
	
	public void construirTerreno(int cantFilas, int cantColumnas){
		ubicaciones = new UbicacionDTO[cantFilas][cantColumnas];
		for (int i = 0; i < cantFilas; i++) {
			for (int j = 0; j < cantColumnas; j++) {
				UbicacionDTO ubicacion = new UbicacionDTO(i, j);
				ubicaciones[i][j] = ubicacion;
			}
		}
	}
	
	public boolean ocuparUbicacion(UbicacionDTO ubicacion){
		int fila = ubicacion.getFila();
		int columna = ubicacion.getColumna();
		if(!ubicaciones[fila][columna].isEstado()){
			ubicaciones[fila][columna].setEstado(true);
			return true;
		}
		else return false;
	}
	
	public boolean desocuparUbicacion(UbicacionDTO ubicacion){
		int fila = ubicacion.getFila();
		int columna = ubicacion.getColumna();
		if(ubicaciones[fila][columna].isEstado()){
			ubicaciones[fila][columna].setEstado(false);
			return true;
		}
		else return false;
	}
	
	public UbicacionDTO[][] mostrarTerreno(){
		return ubicaciones;
	}
}
