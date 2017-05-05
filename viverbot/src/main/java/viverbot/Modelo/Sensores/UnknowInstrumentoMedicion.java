package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.EmptyMagnitud;
import viverbot.Modelo.Magnitudes.Magnitud;

public class UnknowInstrumentoMedicion extends InstrumentoMedicion {

	@Override
	protected Magnitud obtenerMedicion() {
		return new EmptyMagnitud(null);
	}

}
