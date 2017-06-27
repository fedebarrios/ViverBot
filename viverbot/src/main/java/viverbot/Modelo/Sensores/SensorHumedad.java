package viverbot.Modelo.Sensores;

import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Humedad;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class SensorHumedad implements Medir {

	
	@Override
	public Medicion getMedicion() {
		return this.simularMedicion();
	}

	protected Medicion simularMedicion() {
		EstadoVivero a = EstadoVivero.getInstance();
		return a.getHumedadActual();
		
	}

}
