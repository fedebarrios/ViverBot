package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Simulacion.Simulador;

public class SensorTemperatura implements IMedir {

	private Simulador s;

	@Override
	public Medicion getMedicion() {

		return this.simularMedicion();
	}

	protected Medicion simularMedicion() {
		return s.getMedicion();
	}

	public void setSimulador(Simulador simulador) {
		this.s = simulador;
	}

}
