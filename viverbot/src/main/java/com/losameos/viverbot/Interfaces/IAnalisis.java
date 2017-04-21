package com.losameos.viverbot.Interfaces;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.DiagnosticoAnalisis;

public interface IAnalisis {
	
	public DiagnosticoAnalisis analizar(Magnitud m, RangoNumerico rangoIdeal);

}
