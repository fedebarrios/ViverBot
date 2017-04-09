package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class SensorTemperatura extends InstrumentoMedicion {

	@Override
	protected Magnitud simularMedicion() {
		return Ambiente.getTemperatura();
	}

}
