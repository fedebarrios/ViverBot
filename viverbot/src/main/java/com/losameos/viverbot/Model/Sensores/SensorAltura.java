package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class SensorAltura extends Sensor {
	
	public SensorAltura(){
		
	}

	@Override
	protected Magnitud simularMedicion() {
		Altura alt = new Altura("2metros");
		Magnitud ret = new Magnitud(alt.getCentimetros());
		return ret;
	}
}
