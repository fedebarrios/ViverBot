package com.losameos.viverbot.Model.Magnitudes;

import org.junit.Test;

import junit.framework.TestCase;

public class TemperaturaTest extends TestCase {

	@Test
	public void testVerificarClase() {
		Temperatura temperaturaTest =  new Temperatura(9.0);
		assertTrue(temperaturaTest.getValor() instanceof Double);
		assertTrue(temperaturaTest.getValor().equals(9.0));


	}

}
