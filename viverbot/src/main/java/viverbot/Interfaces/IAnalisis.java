package viverbot.Interfaces;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public interface IAnalisis {
	
	public DiagnosticoAnalisis analizar(Magnitud m, RangoNumerico rangoIdeal);

}
