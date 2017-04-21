package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.TransmisorAltura;

public class TransmisorAlturaTest {
	TransmisorAltura trasnmisorTest = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertNotNull(this.trasnmisorTest.getAnalizador());
		this.clear();
	}

	@Test
	public void transmitirTest() throws InterruptedException {
		this.inicialize();
		Altura a =  new Altura(230,"cm");
		ArrayList<Magnitud> alturas = new ArrayList<Magnitud>();
		alturas.add(a);
		this.trasnmisorTest.Transmitir(alturas);
		Magnitud ret = this.trasnmisorTest.getAnalizador().getAlturasRecibidas().get(0);
		assertNotNull(ret);
		assertEquals(ret, a);
		this.clear();
	}

	private void inicialize() {
		this.trasnmisorTest = new TransmisorAltura();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}
}
