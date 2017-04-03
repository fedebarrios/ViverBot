package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Humedad;

public class SensorHumedad {

	public SensorHumedad(){
		
	}
	
	public Humedad getMedicion(){
		return obtenerMedicion();
	}

	private Humedad obtenerMedicion() {
		return simularHumedad();
	}

	private Humedad simularHumedad() {
		Humedad ret = new Humedad((double)Hora.obtenerHoraActual().getMinuto());
		return ret;
	}
	

}
