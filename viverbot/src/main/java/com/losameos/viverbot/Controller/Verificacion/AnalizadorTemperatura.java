package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class AnalizadorTemperatura extends Analizador {
	private EstadoTemperatura estado;

	public AnalizadorTemperatura() {
		this.rango = this.obtenerRango();
	}

	private RangoNumerico obtenerRango() {
		return new RangoNumerico(5.0, 50.0);
	}

	public void analizar(Temperatura temperaturaActual) {
		this.estado = new EstadoTemperatura(temperaturaActual, false);

		if (verificarRango(temperaturaActual)) {
			this.estado.setOptima(true);
			System.out.println(
					"la temperatura es: " + this.estado.getTemperatura().getValor() + " y ademas es bonita :v");
		} else {
			System.out
					.println("la temperatura es: " + this.estado.getTemperatura().getValor() + " y ademas es mala >:v");
		}

	}

}