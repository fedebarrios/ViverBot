package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Interfaces.IAnalisisAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class StrategyMetroDown implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Magnitud m, SeguimientoAltura seguimiento) {
		return new EstadoAlturaNoComparada("MetroDown");
	}

}
