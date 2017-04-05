package com.losameos.viverbot.Controller.Medicion.Temperatura;

import com.losameos.viverbot.Model.Medicion.ColectorTemperatura;

import junit.framework.TestCase;

public class ColectorTemperaturaTest extends TestCase {

	private static ColectorTemperatura colector;

	// este test verifica que la temperatura obtentenida sea correcta
	public void testObtenerTemperatura() {
		inicialize();
		//colector.run();
		
	}

	// este test verifica que la medicion no cambie entes de que trancurra el
	// tiempo indicado
	public void testTiempoTrancurrido() {

	}

	// este test verifica que al trancuurrir el tiempo establecido se tome una
	// nueva medicion
	public void testNuevaMedicion() {

	}

	private void inicialize() {
		colector = new ColectorTemperatura();
	}

	private void clear() {
		//colector.interrupt();
		colector = null;
	}

}
