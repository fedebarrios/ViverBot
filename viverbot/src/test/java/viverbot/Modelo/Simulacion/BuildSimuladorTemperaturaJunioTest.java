package viverbot.Modelo.Simulacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class BuildSimuladorTemperaturaJunioTest {

	private static final IBuildSimulador b = new BuildSimuladorTemperaturaJunio();
	private static final Simulador s = b.getSimulador();

	
	@Test
	public void testGetSimuladorMañana() {
		Hora h0 = new Hora(9, 0, 0);
		Hora h1 = new Hora(10, 0, 0);
		Hora h2 = new Hora(11, 0, 0);
		RangoNumerico r = new RangoNumerico(7.0, 15.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

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
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

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
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitudes.TEMPERATURA);

	}
 

}
