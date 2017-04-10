package com.losameos.viverbot.Model;

import com.losameos.viverbot.DTO.PlantaDTO;

public class SeguimientoAltura {
	private PlantaDTO planta;
	private Historial historialOptimo;
	private Historial historialVerdadero;
	
	public SeguimientoAltura(PlantaDTO p, Historial h1, Historial h2){
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

	public Historial getHistorialOptimo() {
		return historialOptimo;
	}

	public void setHistorialOptimo(Historial historialOptimo) {
		this.historialOptimo = historialOptimo;
	}

	public Historial getHistorialVerdadero() {
		return historialVerdadero;
	}

	public void setHistorialVerdadero(Historial historialVerdadero) {
		this.historialVerdadero = historialVerdadero;
	}
	
	
}
