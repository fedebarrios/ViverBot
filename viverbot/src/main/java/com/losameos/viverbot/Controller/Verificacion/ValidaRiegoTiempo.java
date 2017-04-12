package com.losameos.viverbot.Controller.Verificacion;

public class ValidaRiegoTiempo {
	ControlTiempo controlTiempo;

	public ValidaRiegoTiempo() {
		controlTiempo=new ControlTiempo();
	}
	
	public String cantidadOptimaRiego(){
		String cantidad="NORMAL";
		if(controlTiempo.esDia()&&controlTiempo.esVerano()){
			cantidad="ALTA";
		}else if(controlTiempo.esDia()&&controlTiempo.esInvierno()){
			cantidad="BAJA";
		}
		return cantidad;
	}
	
}
