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
	
	public static boolean extensionImagenValida(String path){
		String extension = path.substring(path.length()-3, path.length());
		if( extension.equalsIgnoreCase("bmp") || extension.equalsIgnoreCase("gif") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg")){
			return true;
		}
		return false;
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
