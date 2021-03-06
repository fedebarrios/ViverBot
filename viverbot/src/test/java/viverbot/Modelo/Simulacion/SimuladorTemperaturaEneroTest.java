package viverbot.Modelo.Simulacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class SimuladorTemperaturaEneroTest {

	private static final String rangos = "#15,19#10,17#15,20#18,25#25,32#27,35#20,30#17,25#";
	private static final Simulador s = new Simulador(Simulador.inicializarRangos(rangos), 300000, Magnitud.TEMPERATURA);

	
	@Test
	public void testGetSimuladorMañana() {
		Hora h0 = new Hora(9, 0, 0);
		Hora h1 = new Hora(10, 0, 0);
		Hora h2 = new Hora(11, 0, 0);
		RangoNumerico r = new RangoNumerico(18.0, 25.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

	}

	

	@Test
	public void testGetSimuladorTarde() {
		Hora h0 = new Hora(15, 0, 0);
		Hora h1 = new Hora(16, 0, 0);
		Hora h2 = new Hora(17, 0, 0);
		RangoNumerico r = new RangoNumerico(27.0, 35.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

	}

	

	@Test
	public void testGetSimuladorNoche() {
		Hora h0 = new Hora(21, 0, 0);
		Hora h1 = new Hora(22, 0, 0);
		Hora h2 = new Hora(23, 0, 0);
		RangoNumerico r = new RangoNumerico(17.0, 25.0);
		
		s.setHoraActual(h0);
		Medicion m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		
		s.setHoraActual(h1);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		
		s.setHoraActual(h2);
		m = s.getMedicion();
		assertTrue(m.getValor() >= r.getMinimo() && m.getValor() <= r.getMaximo());
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

	}

}
