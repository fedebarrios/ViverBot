package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class AnalizadorTemperatura {
	private EstadoTemperatura estado;
	private RangoNumerico rango;
	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	public AnalizadorTemperatura() {
		this.rango = this.obtenerRango();
		this.estado = null;
	}

	private RangoNumerico obtenerRango() {
		return rangoIdeal;
	}

	public void analizar(Temperatura temperaturaActual) {
		this.estado = new EstadoTemperatura(temperaturaActual, false);

		if (verificarTemperatura(temperaturaActual)) {
			this.estado.setOptima(true);
			System.out.println(
					"la temperatura es: " + this.estado.getTemperatura().getValor() + " y ademas es bonita :v");
		} else {
			System.out
					.println("la temperatura es: " + this.estado.getTemperatura().getValor() + " y ademas es mala >:v");
		}

	}

	protected boolean verificarTemperatura(Temperatura t) {
		return this.rango.getMinimo() <= t.getValor() && this.rango.getMaximo() >= t.getValor();
	}
	
	

	public EstadoTemperatura getEstado() {
		return estado;
	}

	public RangoNumerico getRango() {
		return rango;
	}

	

	public void setEstado(EstadoTemperatura estado) {
		this.estado = estado;
	}

	public void setRango(RangoNumerico rango) {
		this.rango = rango;
	}
	

	
}
