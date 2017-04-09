package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class SensorTemperatura extends InstrumentoMedicion {

	@Override
	protected Magnitud simularMedicion() {
		return new Temperatura(57.0);
	}

}
