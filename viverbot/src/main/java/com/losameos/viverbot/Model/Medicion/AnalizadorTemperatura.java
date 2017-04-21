package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Controller.Verificacion.StrategyMagnitudInvalida;
import com.losameos.viverbot.Controller.Verificacion.StrategyRangoTemperatura;
import com.losameos.viverbot.Interfaces.IAnalisis;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AnalizadorTemperatura {
	private IAnalisis estrategia;
	private Magnitud m;
	private DiagnosticoAnalisis estado;
	private RangoNumerico rango;

	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	public AnalizadorTemperatura() {
		this.m = null;
		this.estado = null;
		this.rango = rangoIdeal;
	}

	public DiagnosticoAnalisis analizar(Magnitud temp) {
		this.m = temp;
		IAnalisis estrategia = this.getStrategy(m);
		this.estado = estrategia.analizar(m, this.rango);
		return estado;

	}

	private IAnalisis getStrategy(Magnitud temp) {
		if (temp instanceof Temperatura) {
			return new StrategyRangoTemperatura();
		} else {
			return new StrategyMagnitudInvalida();
		}
	}

	public Magnitud getValorRecibido() {
		return m;
	}

	public DiagnosticoAnalisis getEstado() {
		return this.estado;
	}

	public void setRango(RangoNumerico r) {
		this.rango = r;
	}

}
