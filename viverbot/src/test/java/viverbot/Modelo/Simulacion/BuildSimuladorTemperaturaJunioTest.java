package viverbot.Modelo.Simulacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Medicion;

public class BuildSimuladorTemperaturaJunioTest {

	private static final IBuildMedir b = new BuildSimuladorTemperaturaJunio();
	private static final Simulador s = b.getSimulador();

	@Test
	public void testGetSimuladorMediaNoche() {
		Hora h0 = new Hora(0, 0, 0);
		Hora h1 = new Hora(1, 0, 0);
		Hora h2 = new Hora(2, 0, 0);
		RangoNumerico r = new RangoNumerico(0.0, 5.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorMadrugada() {
		Hora h0 = new Hora(3, 0, 0);
		Hora h1 = new Hora(4, 0, 0);
		Hora h2 = new Hora(5, 0, 0);
		RangoNumerico r = new RangoNumerico(2.0, 7.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorAmanecer() {
		Hora h0 = new Hora(6, 0, 0);
		Hora h1 = new Hora(7, 0, 0);
		Hora h2 = new Hora(8, 0, 0);
		RangoNumerico r = new RangoNumerico(5.0, 10.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorMañana() {
		Hora h0 = new Hora(9, 0, 0);
		Hora h1 = new Hora(10, 0, 0);
		Hora h2 = new Hora(11, 0, 0);
		RangoNumerico r = new RangoNumerico(7.0, 15.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorMedioDia() {
		Hora h0 = new Hora(12, 0, 0);
		Hora h1 = new Hora(13, 0, 0);
		Hora h2 = new Hora(14, 0, 0);
		RangoNumerico r = new RangoNumerico(10.0, 17.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorTarde() {
		Hora h0 = new Hora(15, 0, 0);
		Hora h1 = new Hora(16, 0, 0);
		Hora h2 = new Hora(17, 0, 0);
		RangoNumerico r = new RangoNumerico(7.0, 15.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorAtardecer() {
		Hora h0 = new Hora(18, 0, 0);
		Hora h1 = new Hora(19, 0, 0);
		Hora h2 = new Hora(20, 0, 0);
		RangoNumerico r = new RangoNumerico(5.0, 10.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}

	@Test
	public void testGetSimuladorNoche() {
		Hora h0 = new Hora(21, 0, 0);
		Hora h1 = new Hora(22, 0, 0);
		Hora h2 = new Hora(23, 0, 0);
		RangoNumerico r = new RangoNumerico(2.0, 7.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
	}


}
