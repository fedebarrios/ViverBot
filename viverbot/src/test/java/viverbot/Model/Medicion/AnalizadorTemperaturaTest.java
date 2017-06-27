package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.EmptyMagnitud;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;
import viverbot.Modelo.Medicion.MedicionVacioException;

public class AnalizadorTemperaturaTest {
	private RangoNumerico rango = new RangoNumerico(10.0, 20.0);
	private Medicion temperaturaOptima = new Medicion(15.0, Magnitud.TEMPERATURA);
	private Medicion temperaturaBaja = new Medicion(5.0, Magnitud.TEMPERATURA);
	private Medicion temperaturaAlta = new Medicion(25.0, Magnitud.TEMPERATURA);
	private Medicion vacia = new Medicion(0.0, Magnitud.VACIO);

	@Test
	public void AnalizarOptimoTest() throws MedicionVacioException {
		DiagnosticoAnalisis resultado = AnalizadorTemperatura.analizar(temperaturaOptima, rango);
		assertNotNull(resultado);
		assertEquals(resultado.getOptima(), true);
		assertEquals(resultado.getValor(), temperaturaOptima);
		assertTrue(resultado.getDiferencia() == 0.0);

	}

	@Test
	public void AnalizarBajoTest() throws MedicionVacioException {
		DiagnosticoAnalisis resultado = AnalizadorTemperatura.analizar(temperaturaBaja, rango);
		assertNotNull(resultado);
		assertTrue(resultado.getOptima() == false);
		assertTrue((resultado.getValor()).equals(temperaturaBaja));
		assertTrue(resultado.getDiferencia() == -5.0);

	}

	@Test
	public void AnalizarAltoTest() throws MedicionVacioException {
		DiagnosticoAnalisis resultado = AnalizadorTemperatura.analizar(this.temperaturaAlta, rango);
		assertTrue(resultado.getOptima() == false);
		assertTrue(resultado.getValor().equals(this.temperaturaAlta));
		assertNotNull(resultado);
		assertTrue(resultado.getDiferencia() == 5.0);

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
