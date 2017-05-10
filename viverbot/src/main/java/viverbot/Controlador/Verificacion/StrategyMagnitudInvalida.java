package viverbot.Controlador.Verificacion;

import viverbot.Interfaces.IAnalisis;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.EmptyMagnitud;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class StrategyMagnitudInvalida implements IAnalisis {

	@Override
	public DiagnosticoAnalisis analizar(Medicion m, RangoNumerico rangoIdeal) {
		DiagnosticoAnalisis ret =   new DiagnosticoAnalisis(m, false);
		System.out.println("no se reconoce el dato recibido como una medicion de temperautra");
		return ret;
		
	}

}
