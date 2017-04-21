package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Hora;

import com.losameos.viverbot.Model.Estacion;;

public class ControlTiempo {
	private Hora hora;
	private Fecha fecha;
	
	public ControlTiempo(){
		fecha = Fecha.obtenerFechaActual();
		hora = Hora.obtenerHoraActual();
	}
	
	private Estacion buscaEstacion(){
		Estacion estacion = null;

		
		switch(fecha.getMes()){
		  
		   case 3:
		   case 4:
		   case 5:
		    estacion=Estacion.OTOÑO;
		   break;
		   
		   case 6:
		   case 7:
		   case 8:

		    estacion=Estacion.INVIERNO;
		   break;
		   
		   case 9:
		   case 10:
		   case 11:

		    estacion=Estacion.PRIMAVERA;
		   break;
		   
		   case 12:
		   case 1:
		   case 2:

		    estacion=Estacion.VERANO;
		   break;


		  }	
		   return estacion;
	}
	
	


	public Estacion getEstacionAnio() {

		return buscaEstacion();
	}
	
	public boolean esVerano(){

		return (buscaEstacion()==Estacion.VERANO)? true:false;
	}
	public boolean esInvierno(){
		return (buscaEstacion()==Estacion.INVIERNO)? true:false;

	}

	public boolean esDia(){
		int h=hora.getHora();
		boolean esDia=false;
		switch (buscaEstacion()){


		case PRIMAVERA:
			if (h>7 && h<20)
				esDia= true;
		case VERANO:
			if (h>6 && h<21)
				esDia= true;			
		case OTOÑO:	
			if (h>7 && h<20)
				esDia= true;
		case INVIERNO:
			if (h>9 && h<18)
				esDia= true;
		break;
		}	
					
		return esDia;
	}
	
	
}
