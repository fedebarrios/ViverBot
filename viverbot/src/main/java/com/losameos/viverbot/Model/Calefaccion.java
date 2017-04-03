package com.losameos.viverbot.Model;

public class Calefaccion {
	private int intensidad;

	public Calefaccion() {
	}

	public Calefaccion(int intensidad) {
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
