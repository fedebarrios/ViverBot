package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Controller.Verificacion.StrategyMagnitudInvalida;
import com.losameos.viverbot.Controller.Verificacion.StrategyRangoTemperatura;
import com.losameos.viverbot.Interfaces.IAnalisis;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AnalizadorTemperatura {
	private IAnalisis estrategia;
	private Magnitud m;

	public AnalizadorTemperatura() {
		this.estrategia = null;
		this.m = null;
	}

	public void analizar(Magnitud temp) {
		this.m = temp;
		this.estrategia = this.getStrategy(m);
		this.estrategia.analizar(m);
		
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

	
}
