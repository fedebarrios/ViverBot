package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Hora;

public class ControlTiempo {
 
	private String estacion;
	private Hora hora;
	private Fecha fecha;
	
	public ControlTiempo(){
		
	}
	private String buscaEstacion(){
		if (esVerano() || esPrimavera()){
			return "Verano"; 
		}
		return "Verano";
		
	}
	private boolean esVerano() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean esPrimavera() {
		// TODO Auto-generated method stub
		return false;
	}
}
