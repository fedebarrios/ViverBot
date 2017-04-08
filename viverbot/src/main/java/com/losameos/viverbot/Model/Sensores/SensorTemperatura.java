package com.losameos.viverbot.Model.Sensores;


import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class SensorTemperatura extends InstrumentoMedicion {
	
	
	public SensorTemperatura(){
		
	}

	@Override
	protected Magnitud simularMedicion() {
		Temperatura ret = new Temperatura((double)Hora.obtenerHoraActual().getMinuto());
		return ret;
	}
	
	
	

}
