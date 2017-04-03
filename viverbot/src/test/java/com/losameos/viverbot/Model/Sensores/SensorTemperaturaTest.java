package com.losameos.viverbot.Model.Sensores;

import java.util.Scanner;

import com.losameos.viverbot.Model.SensorTemperatura;
import com.losameos.viverbot.Model.Temperatura;

import junit.framework.TestCase;

public class SensorTemperaturaTest extends TestCase {
	private static SensorTemperatura sensorTest = null;
	private static Temperatura temperaturaActualTest = null;

	public void testSensor() {
		inicialize();
		assertNotNull(sensorTest);
		clear();
	}

	public void testGetMedicionVerificarClase() {
		inicialize();
		assertTrue(sensorTest.getMedicion() instanceof Temperatura);
		clear();
	}

	public void testGetMedicion() {
		inicialize();
		System.out.println("ingrese la temperatura actual");
		ingresarTemperatura();

		assertTrue(sensorTest.getMedicion().getValor().equals(temperaturaActualTest.getValor()));
		clear();
	}
	
	public void testGetMedicionErronea() {
		inicialize();
		System.out.println("ingrese una temperatura que no sea la actual");
		ingresarTemperatura();

		assertFalse(sensorTest.getMedicion().getValor().equals(temperaturaActualTest.getValor()));
		clear();
	}

	private void ingresarTemperatura() {
		Scanner s = new Scanner(System.in);
		Double valorIngresado = s.nextDouble();
		temperaturaActualTest = new Temperatura(valorIngresado);

	}

	private void inicialize() {
		temperaturaActualTest = null;
		sensorTest = new SensorTemperatura();
	}

	private void clear() {
		temperaturaActualTest = null;

		sensorTest = null;

	}

}
