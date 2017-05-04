package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.RangoNumerico;
import viverbot.Model.Magnitudes.EmptyMagnitud;
import viverbot.Model.Magnitudes.Temperatura;
import viverbot.Model.Medicion.AnalizadorTemperatura;
import viverbot.Model.Medicion.DiagnosticoAnalisis;

public class AnalizadorTemperaturaTest {
	AnalizadorTemperatura analizadorTest;
	private RangoNumerico rango = new RangoNumerico(10.0, 20.0);
	private Temperatura temperaturaOptima = new Temperatura(15.0);
	private Temperatura temperaturaBaja = new Temperatura(5.0);
	private Temperatura temperaturaAlta = new Temperatura(25.0);
	private EmptyMagnitud vacia =  new EmptyMagnitud(null);

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
		assertTrue(resultado.getOptima() == true);
		assertTrue(resultado.getMagnitud().equals(temperaturaOptima));
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
