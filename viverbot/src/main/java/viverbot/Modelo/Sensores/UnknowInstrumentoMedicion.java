package viverbot.Model.Sensores;

import viverbot.Model.Magnitudes.EmptyMagnitud;
import viverbot.Model.Magnitudes.Magnitud;

public class UnknowInstrumentoMedicion extends InstrumentoMedicion {

	@Override
	protected Magnitud obtenerMedicion() {
		return new EmptyMagnitud(null);
	}

}
