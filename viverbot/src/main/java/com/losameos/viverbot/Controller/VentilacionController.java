package com.losameos.viverbot.Controller;

import com.losameos.viverbot.Model.Ventilacion;

public class VentilacionController {
	private Ventilacion ventilacion;

	public VentilacionController() {
	}

	public void setVentilacion(int intensidad) {
		Ventilacion ventilacion = new Ventilacion(intensidad);
		this.ventilacion = ventilacion;
	}

	public int getIntensidad() {
		return this.ventilacion.getIntensidad();
	}

}
