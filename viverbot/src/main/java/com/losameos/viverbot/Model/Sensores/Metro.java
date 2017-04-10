package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class Metro extends InstrumentoMedicion {
	@Override
	protected Magnitud simularMedicion() {
		return new Altura(1,"m");
		
	}
}
