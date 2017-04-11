package com.losameos.viverbot.Model;

import com.losameos.viverbot.DTO.PlantaDTO;

public class SeguimientoAltura {
	private PlantaDTO planta;
	private HistorialAltura historialOptimo;
	private HistorialAltura historialVerdadero;
	
	public SeguimientoAltura(PlantaDTO p, HistorialAltura h1, HistorialAltura h2){
		this.planta = p;
		this.historialOptimo = h1;
		this.historialVerdadero = h2;
	}

	public PlantaDTO getPlanta() {
		return planta;
	}

	public void setPlanta(PlantaDTO planta) {
		this.planta = planta;
	}

	public HistorialAltura getHistorialOptimo() {
		return historialOptimo;
	}

	public void setHistorialOptimo(HistorialAltura historialOptimo) {
		this.historialOptimo = historialOptimo;
	}

	public HistorialAltura getHistorialVerdadero() {
		return historialVerdadero;
	}

	public void setHistorialVerdadero(HistorialAltura historialVerdadero) {
		this.historialVerdadero = historialVerdadero;
	}
	
	
}
