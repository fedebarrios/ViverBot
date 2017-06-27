package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class UnknowInstrumentoMedicion implements Medir {

	@Override
	public Medicion getMedicion() {
		return new Medicion(0.0,Magnitudes.VACIO);
	}

}
