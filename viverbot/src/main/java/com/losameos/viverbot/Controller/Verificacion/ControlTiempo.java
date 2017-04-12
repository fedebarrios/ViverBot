package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Hora;

public class ControlTiempo {
	private Hora hora;
	private Fecha fecha;
	
	public ControlTiempo(){
		fecha = Fecha.obtenerFechaActual();
		hora = Hora.obtenerHoraActual();
	}
	
	private String buscaEstacion(){
		String estacion="";
		
		switch(fecha.getMes()){
		  
		   case 3:
		   case 4:
		   case 5:
		    estacion="Otoño";
		   break;
		   
		   case 6:
		   case 7:
		   case 8:
		    estacion="Invierno";
		   break;
		   
		   case 9:
		   case 10:
		   case 11:
		    estacion= "Primavera";
		   break;
		   
		   case 12:
		   case 1:
		   case 2:
		    estacion="Verano";
		   break;


		  }	
		   return estacion;
	}
	
	
	public String getEstacionAnio() {
		return buscaEstacion();
	}
	
	public boolean esVerano(){
		return (buscaEstacion()=="Verano")? true:false;
	}
	public boolean esInvierno(){
		return (buscaEstacion()=="Verano")? true:false;
	}

	public boolean esDia(){
		int h=hora.getHora();
		boolean esDia=false;
		switch (buscaEstacion()){

		case "Primavera":
			if (h>7 && h<20)
				esDia= true;
		case "Verano":
			if (h>6 && h<21)
				esDia= true;			
		case "Otoño":	
			if (h>7 && h<20)
				esDia= true;
		case "Invierno":
			if (h>9 && h<18)
				esDia= true;
		break;
		}	
					
		return esDia;
	}
	
	
}
