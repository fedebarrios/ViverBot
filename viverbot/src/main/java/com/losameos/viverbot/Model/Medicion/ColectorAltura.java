package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Interfaces.IMovible;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Sensores.SensorTemperatura;

public class ColectorAltura extends Colector implements IMovible{

	public ColectorAltura() {
		super(new SensorTemperatura());
	}
	
	@Override
	public void mover(Ubicacion u){
		
	}
}
