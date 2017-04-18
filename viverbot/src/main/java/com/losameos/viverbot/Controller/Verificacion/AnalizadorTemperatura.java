package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AnalizadorTemperatura {
	private IAnalisis estrategia;

	public AnalizadorTemperatura() {
		this.estrategia = null;
	}

	public void analizar(Magnitud temp) {
		this.estrategia = this.getStrategy(temp);
		this.estrategia.analizar(temp);

	}

	private IAnalisis getStrategy(Magnitud temp) {
		if (temp instanceof Temperatura) {
			return new StrategyRangoTemperatura();
		} else {
			return new StrategyMagnitudInvalida();
		}
	}

}
