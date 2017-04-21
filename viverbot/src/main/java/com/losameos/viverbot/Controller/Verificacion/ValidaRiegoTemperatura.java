package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.NivelRiego;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class ValidaRiegoTemperatura {
	TransmisorTemperaturaActual transmTempActual;
	RangoNumerico rangoIdeal = new RangoNumerico(25.0, 5.0);

	public ValidaRiegoTemperatura() {
		transmTempActual =new TransmisorTemperaturaActual();
		
	}

	
	public NivelRiego riegoOptimoPorTemperatura(){
		Temperatura temperaturaActual= transmTempActual.getTemperaturaActual();
		NivelRiego nivel=NivelRiego.NORMAL;
		
		if (temperaturaActual.getValor()> rangoIdeal.getMaximo()){
			nivel= NivelRiego.AUMENTAR;
		}else if(temperaturaActual.getValor()< rangoIdeal.getMinimo()){
			nivel= NivelRiego.BAJAR;
		}
		return nivel;
	}
}
