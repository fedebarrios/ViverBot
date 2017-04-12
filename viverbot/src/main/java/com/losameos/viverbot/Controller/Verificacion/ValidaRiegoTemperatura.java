package com.losameos.viverbot.Controller.Verificacion;

public class ValidaRiegoTemperatura {
	TransmisorTemperaturaActual tempActual;

	public ValidaRiegoTemperatura() {
		tempActual =new TransmisorTemperaturaActual();
		
	}

	
	public String riegoOptimoParaTemperatura(){
		if (tempActual.colector.getInstrumentoMedicion().getMedicion().getValor()> 25){
			return "Alto";
		}else if(tempActual.colector.getInstrumentoMedicion().getMedicion().getValor()< 5){
			return "Bajo";
		}
		return "Normal";
	}
}
