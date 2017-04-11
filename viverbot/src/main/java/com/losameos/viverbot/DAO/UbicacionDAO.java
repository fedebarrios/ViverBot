package com.losameos.viverbot.DAO;

import com.losameos.viverbot.DTO.UbicacionDTO;

public class UbicacionDAO {
	
	private UbicacionDTO[][] ubicaciones;
	private TerrenoDAO terreno;
	
	public UbicacionDAO(TerrenoDAO terreno){
		this.terreno = terreno;
		ubicaciones = terreno.mostrarTerreno();
	}
	
	public boolean esUbicacionLibre(UbicacionDTO ubicacion){
		int fila= ubicacion.getFila();
		int columna = ubicacion.getColumna();
		return ubicaciones[fila][columna].isEstado();
	}
	
	public boolean ocuparUbicacion(UbicacionDTO ubicacion){
		return terreno.ocuparUbicacion(ubicacion);
	}
	
	public boolean desocuparUbicacion(UbicacionDTO ubicacion){
		return terreno.desocuparUbicacion(ubicacion);
	}
	
	public UbicacionDTO[][] mostrarUbicaciones(){
		return terreno.mostrarTerreno();
	}
	
}
