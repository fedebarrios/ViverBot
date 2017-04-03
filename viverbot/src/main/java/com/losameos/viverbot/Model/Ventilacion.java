package com.losameos.viverbot.Model;

public class Ventilacion {
	private int intensidad;

	public Ventilacion() {
	}

	public Ventilacion(int intensidad) {
		this.intensidad = intensidad;
	}

	public int getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(int intensidad) {
		if (intensidad >= 0 && intensidad <= 3) {
			this.intensidad = intensidad;
		} else
			throw new IllegalArgumentException("La intensidad debe ser 0, 1, 2 o 3.");
	}

}
