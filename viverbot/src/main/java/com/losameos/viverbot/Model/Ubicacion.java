package com.losameos.viverbot.Model;

public class Ubicacion {
	
	private Integer fila;
	private Integer columna;
	
	public Ubicacion(Integer fila, Integer columna)
	{
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
