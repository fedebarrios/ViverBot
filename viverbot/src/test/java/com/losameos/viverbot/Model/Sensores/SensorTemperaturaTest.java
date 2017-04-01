package com.losameos.viverbot.Model.Sensores;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

import junit.framework.TestCase;

public class SensorTemperaturaTest extends TestCase {
	private static Double valorTest = 15.00;
	private static Temperatura temperaturaTest = null;
	private static SensorTemperatura  sensorTest = null;
	private static Temperatura temperaturaActualTest=  null;
	
	public void testSensor(){
		inicialize();
		assertNotNull(sensorTest);
		clear();
	}

	public void testGetMedicionVerificarClase(){
		inicialize();
		assertTrue(sensorTest.getMedicion() instanceof Temperatura);
		clear();
	}
	
	public void testGetMedicion() {
		inicialize();
		Double temperaturaActual= (double)Hora.obtenerHoraActual().getMinuto();
		assertTrue(sensorTest.getMedicion().getValor().equals(temperaturaActualTest.getValor()));
		clear();
		}
	
	
	
	private void inicialize() {
		temperaturaTest = new Temperatura(valorTest);
		temperaturaActualTest = new Temperatura((double)Hora.obtenerHoraActual().getMinuto());
		sensorTest = new SensorTemperatura();
	}

	private void clear() {
		temperaturaTest = null;
		sensorTest = null;

	}

}
