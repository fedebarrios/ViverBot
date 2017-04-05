package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class Analizador {
	protected RangoNumerico rango;

	public boolean verificarRango(Magnitud m) {
		return this.rango.getMinimo() <= m.getValor() && this.rango.getMaximo() >= m.getValor();
	}

}
