package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class SensorHumedad extends InstrumentoMedicion {

	@Override
	protected Magnitud simularMedicion() {
		return new Humedad(27.0);
		
	}

}
