package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Sensores.SensorHumedad;

//estas clase tiene mucho codigo repetido  seguramente tenga que usar herencia
public class ColectorHumedad extends Colector {

	Ubicacion ubicacion;

	public ColectorHumedad() {
		super(new SensorHumedad());
		this.ubicacion = null;

	}

	public void mover(Ubicacion u) {
		this.setUbicacion(u);
	}

	private void setUbicacion(Ubicacion u) {
		this.ubicacion = u;
	}

}
