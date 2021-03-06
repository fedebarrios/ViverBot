package viverbot.Modelo.Sensores;

import org.junit.Test;

import junit.framework.TestCase;
import viverbot.Model.EstadoVivero;
import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.SensorTemperatura;

import viverbot.Modelo.Simulacion.Simulador;

public class SensorTemperaturaTest extends TestCase {
	private static SensorTemperatura sensorTest = null;
	private Medicion medicion = new Medicion(5.0, Magnitud.TEMPERATURA);

	@Test
	public void testGetMedicion() {
		inicialize();

		assertEquals(sensorTest.getMedicion().getTipo(), Magnitud.TEMPERATURA);
		assertEquals(sensorTest.getMedicion(), medicion);

		clear();
	}

	/// metodos auxiliares

	private void inicialize() {
		sensorTest = new SensorTemperatura();
		medicion = new Medicion(5.0, Magnitud.TEMPERATURA);
		EstadoVivero.getInstance().setTemperaturaActual(medicion);

	}

	private void clear() {

		sensorTest = null;

	}

}
