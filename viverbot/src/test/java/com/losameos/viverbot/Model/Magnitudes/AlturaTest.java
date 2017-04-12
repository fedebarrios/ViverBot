package com.losameos.viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlturaTest {

	@Test
	public void AlturaTestConConstructorEspecificado(){
		Altura altura1 = new Altura(14,"m");
		Altura altura2 = new Altura(7.62,"cm");
		Altura altura3 = new Altura(50,"p");
		Altura altura4 = new Altura(14,"j");
		assertTrue(altura1.getCentimetros()==1400);
		assertTrue(altura2.getPulgadas()==3);
		assertTrue(altura3.getMetros()==1.27);
		assertTrue(altura4.getCentimetros()==0&&altura4.getMetros()==0&&altura4.getPulgadas()==0);
	}
}
