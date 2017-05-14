package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class UnknowInstrumentoMedicion extends InstrumentoMedicion {

	@Override
	protected Medicion obtenerMedicion() {
		return new Medicion(0.0,Magnitudes.VACIO);
	}

}
