package com.losameos.viverbot.Model.Sensores;

import java.util.Calendar;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class SensorTemperatura {
	
	
	public Temperatura getMedicion(){
		return this.obtenerTemmperatura();
	}

	private Temperatura obtenerTemmperatura() {
		return this.SimularTemperatura();
	}

	private Temperatura SimularTemperatura() {
		Calendar calendar =  Calendar.getInstance();
		Double minutoActual = (double) calendar.get(Calendar.MINUTE);
		Temperatura ret =  new Temperatura(minutoActual);
		return ret;
	}

}
