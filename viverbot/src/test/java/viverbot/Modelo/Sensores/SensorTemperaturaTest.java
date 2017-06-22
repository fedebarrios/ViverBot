package viverbot.Modelo.Sensores;

import org.junit.Test;

import junit.framework.TestCase;
import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.SensorTemperatura;

import viverbot.Modelo.Simulacion.Simulador;

public class SensorTemperaturaTest extends TestCase {
	private static SensorTemperatura sensorTest = null;
	private static final String rangos = "#15,19#10,17#15,20#18,25#25,32#27,35#20,30#17,25#";

	private static Simulador simuladorEnero = new Simulador(Simulador.inicializarRangos(rangos), Magnitudes.TEMPERATURA,
			300000);

	// este test verifica que el return sea de tipo temperatura

	// este test verifica que la temperatura sea correcta durante el cada
	// horario definido
	@Test
	public void testGetMedicionMediaNoche() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(0, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionMadrugada() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(3, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionAmanecer() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(6, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionMañana() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(9, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionMediodia() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(12, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionTarde() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(15, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionAtardecer() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(18, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	@Test
	public void testGetMedicionNoche() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora h = new Hora(21, 0, 0);
		simuladorEnero.setHoraActual(h);
		Medicion m = simuladorEnero.getMedicion();
		Medicion m1 = sensorTest.getMedicion();

		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);
		assertEquals(m, m1);

		clear();
	}

	/// metodos auxiliares

	private void inicialize() {
		sensorTest = new SensorTemperatura();

	}

	private void clear() {

		sensorTest = null;

	}

}
