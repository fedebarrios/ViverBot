package viverbot.Controlador.Verificacion;

import viverbot.Interfaces.IAnalisis;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.EmptyMagnitud;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class StrategyMagnitudInvalida implements IAnalisis {

	@Override
	public DiagnosticoAnalisis analizar(Magnitud m, RangoNumerico rangoIdeal) {
		EmptyMagnitud t = (EmptyMagnitud) m;
		DiagnosticoAnalisis ret =   new DiagnosticoAnalisis(t, false);
		System.out.println("no se reconoce el dato recibido como una medicion de temperautra");
		return ret;
		
	}

}
