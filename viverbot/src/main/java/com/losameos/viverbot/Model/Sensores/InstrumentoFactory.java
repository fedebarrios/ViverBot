package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class InstrumentoFactory {

	public static InstrumentoMedicion creatInstrumento(Magnitudes m) {
		if (m.equals(Magnitudes.TEMPERATURA)) {
			return new SensorTemperatura();
		} else if (m.equals(Magnitudes.HUMEDAD)) {
			return new SensorHumedad();
		}
		return null;

	}

}
