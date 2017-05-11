package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.EmptyMagnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class AnalizadorTemperaturaTest {
	AnalizadorTemperatura analizadorTest;
	private RangoNumerico rango = new RangoNumerico(10.0, 20.0);
	private Medicion temperaturaOptima = new Medicion(15.0, Magnitudes.TEMPERATURA);
	private Medicion temperaturaBaja = new Medicion(5.0,Magnitudes.TEMPERATURA);
	private Medicion temperaturaAlta = new Medicion(25.0,Magnitudes.TEMPERATURA);
	private Medicion vacia = new Medicion(null,Magnitudes.VACIO);

	@Test
	public void AnalizadorTest() {
		this.inicialize();
		assertNull(this.analizadorTest.getValorRecibido());
		assertNull(this.analizadorTest.getEstado());

		this.clear();
	}

	@Test
	public void AnalizarOptimoTest() {
		this.inicialize();
		this.analizadorTest.setRango(this.rango);
		DiagnosticoAnalisis resultado = this.analizadorTest.analizar(temperaturaOptima);
		assertNotNull(resultado);
		assertEquals(resultado.getOptima(), true);
		assertEquals(resultado.getMagnitud(), temperaturaOptima);
		assertTrue(resultado.getDiferencia() == 0.0);
		
		this.clear();

	}

	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
		this.analizadorTest.setRango(this.rango);
		DiagnosticoAnalisis resultado = this.analizadorTest.analizar(temperaturaBaja);
		assertNotNull(resultado);
		assertTrue(resultado.getOptima() == false);
		assertTrue((resultado.getMagnitud()).equals(temperaturaBaja));
		assertTrue(resultado.getDiferencia() == -5.0);

		this.clear();

	}

	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
		this.analizadorTest.setRango(this.rango);
		DiagnosticoAnalisis resultado = this.analizadorTest.analizar(this.temperaturaAlta);
		assertTrue(resultado.getOptima() == false);
		assertTrue(resultado.getMagnitud().equals(this.temperaturaAlta));
		assertNotNull(resultado);
		assertTrue(resultado.getDiferencia() == 5.0);

		this.clear();

	}
	
	@Test
	public void AnalizarVacioTest() {
		this.inicialize();
		this.analizadorTest.setRango(this.rango);
		DiagnosticoAnalisis resultado = this.analizadorTest.analizar(this.vacia);
		assertTrue(resultado.getOptima() == false);
		assertTrue(resultado.getMagnitud().getValor() == null);
		assertNotNull(resultado);
		this.clear();

	}
	// metodos auxiliares

	private void inicialize() {
		this.analizadorTest = new AnalizadorTemperatura();

	}

	private void clear() {
		this.analizadorTest = null;
	}

}
