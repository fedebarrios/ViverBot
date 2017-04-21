package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Test;


public class ColectorAlturaTest {
	ColectorAltura colector = null;

	@Test
	public void testColectorTemperatura() {
		this.inicialize();
		assertNotNull(this.colector.getMediator());
		assertNotNull(this.colector.getTimer());
		assertNull(this.colector.getValorActual());
		this.clear();
	}

	@Test
	public void testColectar() throws InterruptedException {
		this.inicialize();
		this.colector.colectar();
		this.esperar(2000);
		assertNotNull(this.colector.getValorActual());

		this.clear();
	}

	private void inicialize() {
		this.colector = new ColectorAltura();
	}
	
	private void esperar(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);

	}

	private void clear() {
		this.colector.detenerColeccion();
		this.colector = null;
	}
}
