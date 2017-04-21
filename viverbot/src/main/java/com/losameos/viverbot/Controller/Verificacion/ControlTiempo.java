package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Hora;
<<<<<<< HEAD
import com.losameos.viverbot.Model.Estacion;;
=======
>>>>>>> origin/master

public class ControlTiempo {
	private Hora hora;
	private Fecha fecha;
	
	public ControlTiempo(){
		fecha = Fecha.obtenerFechaActual();
		hora = Hora.obtenerHoraActual();
	}
	
<<<<<<< HEAD
	private Estacion buscaEstacion(){
		Estacion estacion = null;
=======
	private String buscaEstacion(){
		String estacion="";
>>>>>>> origin/master
		
		switch(fecha.getMes()){
		  
		   case 3:
		   case 4:
		   case 5:
<<<<<<< HEAD
		    estacion=Estacion.OTOÑO;
=======
		    estacion="Otoño";
>>>>>>> origin/master
		   break;
		   
		   case 6:
		   case 7:
		   case 8:
<<<<<<< HEAD
		    estacion=Estacion.INVIERNO;
=======
		    estacion="Invierno";
>>>>>>> origin/master
		   break;
		   
		   case 9:
		   case 10:
		   case 11:
<<<<<<< HEAD
		    estacion=Estacion.PRIMAVERA;
=======
		    estacion= "Primavera";
>>>>>>> origin/master
		   break;
		   
		   case 12:
		   case 1:
		   case 2:
<<<<<<< HEAD
		    estacion=Estacion.VERANO;
=======
		    estacion="Verano";
>>>>>>> origin/master
		   break;


		  }	
		   return estacion;
	}
	
	
<<<<<<< HEAD
	public Estacion getEstacionAnio() {
=======
	public String getEstacionAnio() {
>>>>>>> origin/master
		return buscaEstacion();
	}
	
	public boolean esVerano(){
<<<<<<< HEAD
		return (buscaEstacion()==Estacion.VERANO)? true:false;
	}
	public boolean esInvierno(){
		return (buscaEstacion()==Estacion.INVIERNO)? true:false;
=======
		return (buscaEstacion()=="Verano")? true:false;
	}
	public boolean esInvierno(){
		return (buscaEstacion()=="Verano")? true:false;
>>>>>>> origin/master
	}

	public boolean esDia(){
		int h=hora.getHora();
		boolean esDia=false;
		switch (buscaEstacion()){

<<<<<<< HEAD
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
=======
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
>>>>>>> origin/master
			if (h>9 && h<18)
				esDia= true;
		break;
		}	
					
		return esDia;
	}
	
	
}
