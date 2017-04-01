package com.losameos.viverbot.Model.Magnitudes;

import junit.framework.TestCase;

public class TemperaturaTest extends TestCase {

	private static Double valorTest = 15.00;
	private static Temperatura temperaturaTest = null;

	public void testTemperatura() {
		inicialize();
		assertNotNull(temperaturaTest);
		this.clear();

	}

	public void testVerificarClase() {
		inicialize();
		assertTrue(temperaturaTest.getValor() instanceof Double);
		clear();

	}

	public void testGetValor() {
		inicialize();
		assertTrue(valorTest == temperaturaTest.getValor());
		clear();
	}

	private void inicialize() {
		temperaturaTest = new Temperatura(valorTest);
	}

	private void clear() {
		temperaturaTest = null;
	}

}
