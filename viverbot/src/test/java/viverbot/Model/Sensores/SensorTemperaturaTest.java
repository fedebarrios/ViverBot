package viverbot.Model.Sensores;


import org.junit.Test;

import junit.framework.TestCase;
import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaEnero;
import viverbot.Modelo.Simulacion.BuildSimuladorTemperaturaJunio;
import viverbot.Modelo.Simulacion.IBuildSimulador;
import viverbot.Modelo.Simulacion.Simulador;

public class SensorTemperaturaTest extends TestCase {
	private static SensorTemperatura sensorTest = null;
	private static final IBuildSimulador bEnero = new BuildSimuladorTemperaturaEnero();
	private static  Simulador simuladorEnero = bEnero.getSimulador();
	private static final IBuildSimulador bJunio = new BuildSimuladorTemperaturaJunio();
	private static  Simulador simuladorJunio = bJunio.getSimulador();

	// este test verifica que el return sea de tipo temperatura
	

	// este test verifica que la temperatura sea correcta durante el cada
	// horario definido
	@Test
	public void testGetMedicionMediaNoche() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora noche = new Hora(0, 0, 0);
		simuladorEnero.setHoraActual(noche);
		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		Medicion ms = simuladorEnero.getMedicion();

		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}
		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
		clear();
	}

	@Test
	public void testGetMedicionMadrugada() {
		inicialize();
		Hora noche = new Hora(3, 0, 0);
		simuladorEnero.setHoraActual(noche);
		sensorTest.setSimulador(simuladorEnero);

		
		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		Medicion ms = simuladorEnero.getMedicion();

		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}

		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
		clear();
	}@Test
	public void testGetMedicionAmanecer() {
		inicialize();
		
		Hora h = new Hora(6,0,0);
		simuladorEnero.setHoraActual(h);
		System.out.println(simuladorEnero.getMedicion().getValor());
		clear();
	}@Test
	public void testGetMedicionMañana() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora noche = new Hora(9, 0, 0);
		simuladorEnero.setHoraActual(noche);
		Medicion ms = simuladorEnero.getMedicion();

		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);


		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}
		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
		clear();
	}@Test
	public void testGetMedicionMedioDia() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora noche = new Hora(12, 0, 0);
		simuladorEnero.setHoraActual(noche);
		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		Medicion ms = simuladorEnero.getMedicion();

		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}
		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
		clear();
	}@Test
	public void testGetMedicionTarde() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora noche = new Hora(15, 0, 0);
		simuladorEnero.setHoraActual(noche);
		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		Medicion ms = simuladorEnero.getMedicion();

		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}
		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
		clear();
	}@Test
	public void testGetMedicionAtardecer() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);
		Hora noche = new Hora(18, 0, 0);
		simuladorEnero.setHoraActual(noche);
		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		Medicion ms = simuladorEnero.getMedicion();

		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}
		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
		clear();
	}@Test
	public void testGetMedicionNoche() {
		inicialize();
		sensorTest.setSimulador(simuladorEnero);

		Hora noche = new Hora(21, 0, 0);
		simuladorEnero.setHoraActual(noche);
		RangoNumerico r = simuladorEnero.getRango();
		Medicion m = sensorTest.getMedicion();
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		Medicion ms = simuladorEnero.getMedicion();

		double diferencia = m.getValor() - ms.getValor();
		if (diferencia < 0) {
			diferencia = diferencia * -1;
		}
		assertTrue(diferencia <= r.getMaximo() - r.getMinimo());
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
