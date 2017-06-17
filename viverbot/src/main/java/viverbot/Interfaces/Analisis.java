package viverbot.Interfaces;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public interface Analisis {
	
	public DiagnosticoAnalisis analizar(Medicion m, RangoNumerico rangoIdeal);

}
