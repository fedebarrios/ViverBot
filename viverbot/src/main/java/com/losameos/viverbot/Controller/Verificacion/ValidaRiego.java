package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.NivelRiego;

public class ValidaRiego  extends AnalizadorRiego{
	
	
	public ValidaRiego() {
	}

	public NivelRiego cantidadOptimaRiego(){
		return NivelRiego.NORMAL;
	}
}
