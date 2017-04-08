package com.losameos.viverbot.Controller.Verificacion;

import java.sql.Date;
import java.util.Calendar;

public class Verificador {
	
	public static boolean campoExclusivamenteAlfabetico(String campo){
		for(int i=0; i<campo.length(); i++){
			Integer aux = (int) campo.charAt(i);
			if(aux!=null){
				return false;
			}
		}
		return true;
	}
	
	public static boolean fechaFutura(Date fecha){
		Calendar fechaActual = Calendar.getInstance();
		if(fechaActual.getTime().compareTo(fecha)==-1) return true;
		else return false;
	}

	public static boolean fechaPosteriorADueño(Date fecha) {
		return true;
	}
}
