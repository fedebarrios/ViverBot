package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class SensorHumedad extends InstrumentoMedicion {

	
	@Override
	protected Magnitud obtenerMedicion() {
		return this.simularMedicion();
	}

	protected Magnitud simularMedicion() {
		Ambiente a = Ambiente.getInstance();
		return a.getHumedad();
		
	}

}
