package com.losameos.viverbot.Controller.Verificacion;

public class ValidaRiegoTemperatura {
	TransmisorTemperaturaActual tempActual;

	public ValidaRiegoTemperatura() {
		tempActual =new TransmisorTemperaturaActual();
		
	}

	
	public String riegoOptimoParaTemperatura(){
<<<<<<< HEAD
		if (tempActual.getValorTemperatura().getValor()> 25){
			return "Alto";
		}else if(tempActual.getValorTemperatura().getValor()< 5){
=======
		if (tempActual.getValorTemperatura()> 25){
			return "Alto";
		}else if(tempActual.getValorTemperatura()< 5){
>>>>>>> origin/master
			return "Bajo";
		}
		return "Normal";
	}
}
