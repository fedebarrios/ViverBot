package com.losameos.viverbot.Model.Sensores;

import java.util.Random;

import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class Metro extends InstrumentoMedicion {
	private int cantidadDeMediciones = 0;
	@Override
	protected Magnitud simularMedicion() {
		Random random = new Random();
		Altura medicion;
		cantidadDeMediciones++;
		if(cantidadDeMediciones < 3){
			medicion = new Altura( random.nextDouble() * 120 + 100 , "cm");
		}
		else if(cantidadDeMediciones < 5){
			medicion = new Altura( random.nextDouble() * 80 + 120 , "cm");
		}
		else if(cantidadDeMediciones < 8){
			medicion = new Altura( random.nextDouble() * 60 + 140 , "cm");
		}
		else{
			medicion = new Altura( random.nextDouble() * 80 + 100 , "cm");
		}
		return medicion;
		
	}
}
