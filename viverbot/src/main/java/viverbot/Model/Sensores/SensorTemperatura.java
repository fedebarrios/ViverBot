package viverbot.Model.Sensores;

import viverbot.Model.Ambiente;
import viverbot.Model.Magnitudes.Magnitud;

public class SensorTemperatura extends InstrumentoMedicion {

	
	@Override
	protected Magnitud obtenerMedicion() {
		return this.simularMedicion();
	}

	protected Magnitud simularMedicion() {
		Ambiente a = Ambiente.getInstance();
		return a.getTemperatura();
	}

}
