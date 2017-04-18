package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.EmptyMagnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class UnknowInstrumentoMedicion extends InstrumentoMedicion {

	@Override
	protected Magnitud obtenerMedicion() {
		return new EmptyMagnitud(null);
	}

}
