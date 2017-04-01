package com.losameos.viverbot.Model.Sensores;

import java.util.Calendar;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class SensorTemperatura {
	
	
	public SensorTemperatura(){
		
	}
	
	
	public Temperatura getMedicion(){
		
		return obtenerTemmperatura(); 
	}

	private Temperatura obtenerTemmperatura() {
		return this.SimularTemperatura();
	}

	private Temperatura SimularTemperatura() {
		
		Temperatura ret =  new Temperatura((double)Hora.obtenerHoraActual().getMinuto());
		return ret;
	}

}
