package com.losameos.viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

public class HumedadTest {

	@Test
	public void testHumedad() {
		Humedad temperaturaTest =  new Humedad(9.0);
		assertTrue(temperaturaTest.getValor() instanceof Double);
		assertTrue(temperaturaTest.getValor().equals(9.0));
	}

}
