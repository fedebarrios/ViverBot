package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

import com.losameos.viverbot.Model.Medicion.InstrumentoMediator;



public class TransmisorTemperaturaActual extends Transmisor {

	private static Magnitudes m = Magnitudes.TEMPERATURA;


	public TransmisorTemperaturaActual() {
		super(new InstrumentoMediator(m));
		
	}




	public Temperatura getValorTemperatura(){
		
		return new Temperatura(mediador.getInstrumentoMedicion().getMedicion().getValor());
	}
}

