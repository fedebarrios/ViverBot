package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;
import viverbot.Modelo.Medicion.MedicionVacioException;

public class AnalizadorTemperaturaTest {
	private RangoNumerico rango = new RangoNumerico(10.0, 20.0);
	private Medicion vacia = new Medicion(0.0, Magnitud.VACIO);
	
	@Test
	public void AnalizarBajoTest() throws MedicionVacioException {
		Medicion medicion = new Medicion(8.0, Magnitud.TEMPERATURA);

		DiagnosticoAnalisis resultado = AnalizadorTemperatura.analizar(medicion, rango);
		assertNotNull(resultado);
		assertTrue(resultado.getOptima() == false);
		assertTrue((resultado.getValor()).equals(medicion));
		assertTrue(resultado.getDiferencia() == -2.0);

	}

	@Test
	public void AnalizarAltoTest() throws MedicionVacioException {
		 Medicion medicion = new Medicion(24.0, Magnitud.TEMPERATURA);

		DiagnosticoAnalisis resultado = AnalizadorTemperatura.analizar(medicion, rango);
		assertTrue(resultado.getOptima() == false);
		assertTrue(resultado.getValor().equals(medicion));
		assertNotNull(resultado);
		assertTrue(resultado.getDiferencia() == 4.0);

	}
	@Test
	public void AnalizarOptimoTest() throws MedicionVacioException {
		Medicion medicion = new Medicion(15.0, Magnitud.TEMPERATURA);
		DiagnosticoAnalisis resultado = AnalizadorTemperatura.analizar(medicion, rango);
		assertNotNull(resultado);
		assertEquals(resultado.getOptima(), true);
		assertEquals(resultado.getValor(), medicion);
		assertTrue(resultado.getDiferencia() == 0.0);

	}

	

	

	@Test
	public void AnalizarVacioTest() {
		try {
			DiagnosticoAnalisis resultado;

			resultado = AnalizadorTemperatura.analizar(this.vacia, rango);
	        fail("Expected an MedicionVacioException to be thrown");

		} catch (Exception e) {
	        assertEquals(e.getMessage(), "Medicion no reconocida");

		}
		;

	}

}
