package viverbot.Modelo.Sensores;

import viverbot.Model.Ambiente;
import viverbot.Modelo.Magnitudes.Humedad;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class SensorHumedad extends InstrumentoMedicion {

	
	@Override
	protected Medicion obtenerMedicion() {
		return this.simularMedicion();
	}

	protected Medicion simularMedicion() {
		Ambiente a = Ambiente.getInstance();
		return a.getHumedad();
		
	}

}
