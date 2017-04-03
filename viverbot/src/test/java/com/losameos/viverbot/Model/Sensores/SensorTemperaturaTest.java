package com.losameos.viverbot.Model.Sensores;

import java.util.Scanner;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

import junit.framework.TestCase;

public class SensorTemperaturaTest extends TestCase {
	private static SensorTemperatura sensorTest = null;
	private static Temperatura temperaturaActualTest = null;

	//este test verifica que funciona el constructor seguramente lo saquemos :v
	public void testSensor() {
		inicialize();
		assertNotNull(sensorTest);
		clear();
	}

	//este test verifica que el return sea de tipo  temperatura
	public void testGetMedicionVerificarClase() {
		inicialize();
		assertTrue(sensorTest.getMedicion() instanceof Temperatura);
		clear();
	}

	//este test verifica que la temperatura sea correcta
	public void testGetMedicion() {
		inicialize();
		System.out.println("ingrese la temperatura actual");
		ingresarTemperatura();

		assertTrue(sensorTest.getMedicion().getValor().equals(temperaturaActualTest.getValor()));
		clear();
	}
	
	//este test verifica que la temperatura sea diferente a la equivocada
	public void testGetMedicionErronea() {
		inicialize();
		System.out.println("ingrese una temperatura que no sea la actual");
		ingresarTemperatura();

		assertFalse(sensorTest.getMedicion().getValor().equals(temperaturaActualTest.getValor()));
		clear();
	}

	
	///metodos auxiliares
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
