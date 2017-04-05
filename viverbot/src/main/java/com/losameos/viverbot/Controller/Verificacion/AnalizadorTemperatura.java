package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class AnalizadorTemperatura {
	
	RangoNumerico rango;
	EstadoTemperatura estado;
	
	

	public AnalizadorTemperatura() {
		this.rango = this.obtenerRangoTemperatura();
	}



	private RangoNumerico obtenerRangoTemperatura() {
		return new RangoNumerico(5.0, 50.0);
	}



	public void analizar(Temperatura temperaturaActual) {
		this.estado = new EstadoTemperatura(temperaturaActual, false);

		if(verificarRango(temperaturaActual)){
			System.out.println("la temperatura es: " +  this.estado.getTemperatura().getValor() + " y ademas es bonita :v el rango ideal es ");
		}
		else{
			System.out.println("la temperatura es: " +  this.estado.getTemperatura().getValor() + " y ademas es mala >:v");
		}
		
	}



	private boolean verificarRango(Temperatura temperaturaActual) {
		// TODO Auto-generated method stub
		return this.rango.getMinimo()<= temperaturaActual.getValor() && this.rango.getMaximo() >= temperaturaActual.getValor();
	}
	
	

}
