package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public abstract class  InstrumentoMedicion {

	public Magnitud getMedicion() {
		return obtenerMedicion();
	}

	protected Magnitud obtenerMedicion(){
		return null;
	}
	
	
	

}
