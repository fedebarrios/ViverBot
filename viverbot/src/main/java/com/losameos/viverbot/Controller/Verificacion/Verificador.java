package com.losameos.viverbot.Controller.Verificacion;

import java.util.Calendar;
import java.sql.Date;

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
	
	public static void main(String[] args){
		System.out.println(fechaFutura(new Date(2017-1900,4-1,12)));
	}
}
