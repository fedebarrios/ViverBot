package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Interfaces.IAnalisis;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.EmptyMagnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.DiagnosticoAnalisis;

public class StrategyMagnitudInvalida implements IAnalisis {

	@Override
	public DiagnosticoAnalisis analizar(Magnitud m, RangoNumerico rangoIdeal) {
		EmptyMagnitud t = (EmptyMagnitud) m;
		DiagnosticoAnalisis ret =   new DiagnosticoAnalisis(t, false);
		return ret;
		
	}

}
