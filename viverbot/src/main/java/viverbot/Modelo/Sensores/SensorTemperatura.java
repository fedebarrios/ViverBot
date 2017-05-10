package viverbot.Modelo.Sensores;

import viverbot.Model.Hora;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Simulacion.Simulador;

public class SensorTemperatura extends InstrumentoMedicion {

	private Simulador s;

	@Override
	public Medicion getMedicion() {

		return this.simularMedicion();
	}

	protected Medicion simularMedicion() {
		s.setHoraActual(Hora.obtenerHoraActual());
		return s.getMedicion();
	}

	public void setSimulador(Simulador simulador) {
		this.s = simulador;
	}

}
