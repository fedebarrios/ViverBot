package com.losameos.viverbot.Controller;

import com.losameos.viverbot.Model.Calefaccion;

public class CalefaccionController {
	private Calefaccion calefaccion;

	public CalefaccionController() {
	}

	public void setCalefaccion(int intensidad) {
		Calefaccion calefaccion = new Calefaccion(intensidad);
		this.calefaccion = calefaccion;
	}

	public int getIntensidad() {
		return this.calefaccion.getIntensidad();
	}
}
