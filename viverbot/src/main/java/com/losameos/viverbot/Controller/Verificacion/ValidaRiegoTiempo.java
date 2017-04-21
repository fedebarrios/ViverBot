package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.NivelRiego;

public class ValidaRiegoTiempo {
	ControlTiempo controlTiempo;

	public ValidaRiegoTiempo() {
		controlTiempo=new ControlTiempo();
	}
	
	public NivelRiego cantidadOptimaRiego(){
		
		NivelRiego nivel=NivelRiego.NORMAL;
		
		if(controlTiempo.esDeDia()&&controlTiempo.esVerano()){
			nivel =NivelRiego.AUMENTAR;
		}else if(!controlTiempo.esDeDia()&&controlTiempo.esInvierno()){
			nivel =NivelRiego.BAJAR;
		}
		return nivel;
	}
	
}
