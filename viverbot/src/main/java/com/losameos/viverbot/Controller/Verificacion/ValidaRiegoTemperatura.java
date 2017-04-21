package com.losameos.viverbot.Controller.Verificacion;

public class ValidaRiegoTemperatura {
	TransmisorTemperaturaActual tempActual;

	public ValidaRiegoTemperatura() {
		tempActual =new TransmisorTemperaturaActual();
		
	}

	
	public String riegoOptimoParaTemperatura(){
		if (tempActual.getValorTemperatura().getValor()> 25){
			return "Alto";
		}else if(tempActual.getValorTemperatura().getValor()< 5){
			return "Bajo";
		}
		return "Normal";
	}
}
