package viverbot.Modelo.Simulacion;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class SimularTest {

	private static Simulador simulador = null;
	private static Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
	private static Hora medianoche = new Hora(0, 0, 0);
	private static Hora madrugada = new Hora(3, 0, 0);
	private static Hora amanecer = new Hora(6, 0, 0);
	private static Hora mañana = new Hora(9, 0, 0);
	private static Hora mediodia = new Hora(12, 0, 0);
	private static Hora tarde = new Hora(15, 0, 0);
	private static Hora atardecer = new Hora(18, 0, 0);
	private static Hora noche = new Hora(21, 0, 0);

	private static RangoNumerico r1 = new RangoNumerico(0.0, 1.0);
	private static RangoNumerico r2 = new RangoNumerico(1.0, 2.0);
	private static RangoNumerico r3 = new RangoNumerico(2.0, 3.0);
	private static RangoNumerico r4 = new RangoNumerico(3.0, 4.0);
	private static RangoNumerico r5 = new RangoNumerico(4.0, 5.0);
	private static RangoNumerico r6 = new RangoNumerico(5.0, 6.0);
	private static RangoNumerico r7 = new RangoNumerico(6.0, 7.0);
	private static RangoNumerico r8 = new RangoNumerico(7.0, 8.0);

	//actualiza la temperatura actual si horario de mañana
	@Test
	public void testActualizarValorActualMañana() {

		this.inicializar();
		simulador.actualizarValorActual(mañana);
		Medicion m = simulador.getMedicion();
		assertTrue(m.getValor() >= 3.0 && m.getValor() <= 4.0);
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		this.clear();

	}
	//actualiza la temperatura actual si horario de tarde

	@Test
	public void testActualizarValorActualTarde() {

		this.inicializar();
		simulador.actualizarValorActual(tarde);
		Medicion m = simulador.getMedicion();
		assertTrue(m.getValor() >= 5.0 && m.getValor() <= 6.0);
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		this.clear();

	}

	//actualiza la temperatura actual si horario de noche

	@Test
	public void testActualizarValorActualNoche() {

		this.inicializar();
		simulador.actualizarValorActual(noche);
		Medicion m = simulador.getMedicion();
		assertTrue(m.getValor() >= 7.0 && m.getValor() <= 8.0);
		assertEquals(m.getTipo(), Magnitud.TEMPERATURA);

		this.clear();

	}

	//verifica que el simulador trabaje con el rango apropiado segun el horario
	@Test
	public void testGetRangoMedionoche() {
		this.inicializar();
		assertEquals(simulador.getRango(medianoche), r1);
		this.clear();

	}

	@Test
	public void testGetRangoMadrugada() {
		this.inicializar();
		assertEquals(simulador.getRango(madrugada), r2);
		this.clear();
	}

	@Test
	public void testGetRangoAmanecer() {

		this.inicializar();
		assertEquals(simulador.getRango(amanecer), r3);

		this.clear();
	}

	@Test
	public void testGetRangoMañana() {

		this.inicializar();
		assertEquals(simulador.getRango(mañana), r4);

		this.clear();
	}

	@Test
	public void testGetRangoMediodia() {

		this.inicializar();
		assertEquals(simulador.getRango(mediodia), r5);

		this.clear();
	}

	@Test
	public void testGetRangoTarde() {

		this.inicializar();
		assertEquals(simulador.getRango(tarde), r6);

		this.clear();
	}

	@Test
	public void testGetRangoAtardecer() {

		this.inicializar();
		assertEquals(simulador.getRango(atardecer), r7);

		this.clear();
	}

	@Test
	public void testGetRangoNoche() {

		this.inicializar();
		assertEquals(simulador.getRango(noche), r8);

		this.clear();
	}

	//verifica que el simulador este trabajando segun la hora indicada
	@Test
	public void testSetHoraActual() {

		this.inicializar();
		Hora h = new Hora(4, 54, 32);
		simulador.setHoraActual(h);
		assertEquals(simulador.getHora(), h);
		this.clear();

	}

	public void inicializar() {
		r.put(Horario.MEDIANOCHE, r1);
		r.put(Horario.MADRUGADA, r2);
		r.put(Horario.AMANECER, r3);
		r.put(Horario.MAÑANA, r4);
		r.put(Horario.MEDIODIA, r5);
		r.put(Horario.TARDE, r6);
		r.put(Horario.ATARDECER, r7);
		r.put(Horario.NOCHE, r8);
		simulador = new Simulador(r,300000, Magnitud.TEMPERATURA);
	}

	private void clear() {
		simulador = null;
	}

}
