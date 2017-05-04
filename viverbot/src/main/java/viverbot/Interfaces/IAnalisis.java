package viverbot.Interfaces;

import viverbot.Model.RangoNumerico;
import viverbot.Model.Magnitudes.Magnitud;
import viverbot.Model.Medicion.DiagnosticoAnalisis;

public interface IAnalisis {
	
	public DiagnosticoAnalisis analizar(Magnitud m, RangoNumerico rangoIdeal);

}
