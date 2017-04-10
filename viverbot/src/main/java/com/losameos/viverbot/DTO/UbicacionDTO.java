package com.losameos.viverbot.DTO;

public class UbicacionDTO {
	private Integer fila;
	private Integer columna;

	
	
	public UbicacionDTO(Integer fila, Integer columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}
	public Integer getFila() {
		return fila;
	}
	public void setFila(Integer fila) {
		this.fila = fila;
	}
	public Integer getColumna() {
		return columna;
	}
	public void setColumna(Integer columna) {
		this.columna = columna;
	}
	
}
