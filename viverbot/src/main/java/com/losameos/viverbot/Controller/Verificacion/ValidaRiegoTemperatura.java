package com.losameos.viverbot.Controller.Verificacion;

public class ValidaRiegoTemperatura {
	TransmisorTemperaturaActual tempActual;

	public ValidaRiegoTemperatura() {
		tempActual =new TransmisorTemperaturaActual();
		
	}

	
	public boolean temperaturaOptimaParaRiego(){
		if (tempActual.colector.getInstrumentoMedicion().getMedicion().getValor()> 0){
			return true;
		}
		return false;
	}
}
