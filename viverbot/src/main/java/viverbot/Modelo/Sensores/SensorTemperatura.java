package viverbot.Modelo.Sensores;

import viverbot.Model.Ambiente;
import viverbot.Modelo.Magnitudes.Magnitud;

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
