package viverbot.Model.Sensores;

import viverbot.Model.Ambiente;
import viverbot.Model.Magnitudes.Humedad;
import viverbot.Model.Magnitudes.Magnitud;

public class SensorHumedad extends InstrumentoMedicion {

	
	@Override
	protected Magnitud obtenerMedicion() {
		return this.simularMedicion();
	}

	protected Magnitud simularMedicion() {
		Ambiente a = Ambiente.getInstance();
		return a.getHumedad();
		
	}

}
