package com.losameos.viverbot.Model.Medicion;

import java.util.TimerTask;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AutomatizacionDeClima {
	private Temperatura temp;
	private RangoNumerico rango;
	private AireAcondicionado aireAcondicionado;

	public AutomatizacionDeClima(Temperatura temp, RangoNumerico rango) {
		this.temp = temp;
		this.rango = rango;
		this.aireAcondicionado = new AireAcondicionado();
	}

	TimerTask tt = new TimerTask() {

		@Override
		public void run() {
			aireAcondicionado.establecerPotenciaYEstado(temp, rango);
			aireAcondicionado.interferirTemperatura(temp);
			System.out.println(temp.getValor());
		}
	};

	// public boolean veriricarRango() {
	// if (temp.getValor() <= rango.getMaximo()
	// && temp.getValor() >= rango.getMinimo()) {
	// return true;
	// } else
	// return false;
	// }

}
