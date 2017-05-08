package viverbot.Modelo.Simulacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Interfaces.ISimularMedicion;
import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Medicion;

public class BuildSimuladorTemperaturaEneroTest {

	private static final IBuildMedir b = new BuildSimuladorTemperaturaEnero();
	private static final ISimularMedicion s = b.getSimulador();

	@Test
	public void testGetSimuladorMediaNoche() {
		Hora h0 = new Hora(0, 0, 0);
		Hora h1 = new Hora(1, 0, 0);
		Hora h2 = new Hora(2, 0, 0);
		RangoNumerico r = new RangoNumerico(15.0, 19.0);
		Medicion m = s.getMedicion(h0);
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		m = s.getMedicion(h1);
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		m = s.getMedicion(h2);
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorMadrugada() {
		Hora h0 = new Hora(3, 0, 0);
		Hora h1 = new Hora(4, 0, 0);
		Hora h2 = new Hora(5, 0, 0);
		RangoNumerico r = new RangoNumerico(10.0, 17.0);
		
		Medicion m = s.getMedicion(h0);
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		m = s.getMedicion(h1);
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		m = s.getMedicion(h2);
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorAmanecer() {
	}

	@Test
	public void testGetSimuladorMañana() {
	}

	@Test
	public void testGetSimuladorMedioDia() {
	}

	@Test
	public void testGetSimuladorTarde() {
	}

	@Test
	public void testGetSimuladorAtardecer() {
	}

	@Test
	public void testGetSimuladorNoche() {
	}

}
