package com.losameos.viverbot.Model.Sensores;

import java.util.Random;

import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class Metro extends InstrumentoMedicion {
	@Override
	protected Magnitud simularMedicion() {
		Random random = new Random();
		Altura medicion = new Altura( random.nextDouble() * 200 + 100 , "cm");
		return medicion;
		
	}
}
