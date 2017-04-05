package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class SensorHumedad extends Sensor {

	public SensorHumedad() {

	}

	@Override
	protected Magnitud simularMedicion() {
		Humedad ret = new Humedad((double) Hora.obtenerHoraActual().getMinuto());
		return ret;
	}

}
