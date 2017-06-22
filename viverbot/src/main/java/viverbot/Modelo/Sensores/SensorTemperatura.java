package viverbot.Modelo.Sensores;

import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Simulacion.Simulador;

public class SensorTemperatura implements IMedir {


	@Override
	public Medicion getMedicion() {

		return this.simularMedicion();
	}

	protected Medicion simularMedicion() {
		EstadoVivero e = EstadoVivero.getInstance();
		return e.getTemperaturaActual();
	}

	
}
