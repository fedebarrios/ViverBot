package com.losameos.viverbot.Controller;

import com.losameos.viverbot.Model.EstadoTemperatura;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Temperatura;

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
		if (verificarRango(temperaturaActual)) {
			this.estado = new EstadoTemperatura(temperaturaActual, false);
			System.out.println("la temperatura es: " + this.estado.getTemperatura().getValor());
		}
	}

	private boolean verificarRango(Temperatura temperaturaActual) {
		return this.rango.getMinimo() <= temperaturaActual.getValor()
				&& this.rango.getMaximo() >= temperaturaActual.getValor();
	}

}
