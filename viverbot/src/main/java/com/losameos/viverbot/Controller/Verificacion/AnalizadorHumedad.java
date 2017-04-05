package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoHumedad;

public class AnalizadorHumedad extends Analizador{

	EstadoHumedad estado;
	
	
	public AnalizadorHumedad(){
		this.rango = this.obtenerRango();
	}
	private RangoNumerico obtenerRango() {
		return new RangoNumerico(5.0, 50.0);
	}
	public void analizar(Humedad valorActual, Ubicacion u){
		this.estado = new EstadoHumedad(valorActual, false,u);
		if(this.verificarRango(valorActual)){
			this.estado.setOptimo(true);
			System.out.println("la humedad actual es: " +this.estado.getHumedad().getValor() + " y ademas es bonita :v");
		}
		else{
			System.out.println("la humedad actual es: " +this.estado.getHumedad().getValor() + " y ademas es bonita >:v");

		}
		
	}
	
	
	
}
