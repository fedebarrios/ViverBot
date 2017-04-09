package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class InstrumentoFactory {
	private static InstrumentoMedicion sensorTemp;
	private static InstrumentoMedicion sensorHumedad;

	public static InstrumentoMedicion creatInstrumento(Magnitudes m) {
		if (m.equals(Magnitudes.TEMPERATURA)) {
			return getInstanceSensorTemperatura();
		} else if (m.equals(Magnitudes.HUMEDAD)) {
			return getInstanceSensorHumedad();
		}
		return null;

	}

	private static InstrumentoMedicion getInstanceSensorTemperatura() {
		if (sensorTemp == null) {
			sensorTemp = new SensorTemperatura();
		}
		return sensorTemp;
	}

	private static InstrumentoMedicion getInstanceSensorHumedad() {
		if (sensorHumedad == null) {
			sensorHumedad = new SensorHumedad();
		}
		return sensorHumedad;
	}

}
