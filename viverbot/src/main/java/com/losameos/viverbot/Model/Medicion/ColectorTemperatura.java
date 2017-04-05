package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Sensores.SensorTemperatura;

public class ColectorTemperatura extends Colector{
	

	public ColectorTemperatura() {
		super(new SensorTemperatura());
	}

	

	@Override
	public Magnitud tomarMedicion() {
		this.medir();
		return this.valorActual;
	}



	

	
	

	
}
