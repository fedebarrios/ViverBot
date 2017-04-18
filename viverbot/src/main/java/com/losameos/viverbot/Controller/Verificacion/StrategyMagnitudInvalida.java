package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class StrategyMagnitudInvalida implements IAnalisis {

	@Override
	public void analizar(Magnitud m) {
		Alertador.alertar();
	}

}
