package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Sensores.Sensor;

public class Colector {
	protected Sensor sensor;
	protected Magnitud valorActual;

	public Colector(Sensor s) {
		this.sensor = s;
		this.valorActual = null;
	}

	public Magnitud tomarMedicion() {
		this.medir();
		return this.valorActual;
	}

	protected void medir() {
		this.valorActual = this.sensor.getMedicion();
	}

}
