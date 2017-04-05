package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class Sensor {

	public Magnitud getMedicion() {
		return obtenerMedicion();
	}

	protected Magnitud obtenerMedicion(){
		return simularMedicion();
	}
	protected Magnitud simularMedicion(){
		return null;
	}

}
