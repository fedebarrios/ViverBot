package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.EstadoVivero;
import viverbot.Model.Hora;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.Colector;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Sensores.SensorTemperatura;

import viverbot.Modelo.Simulacion.Simulador;

public class ColectorTemperaturaTest {
	private Colector colector = null;
	private InstrumentoMediator m = null;
	private Medicion medicion = new Medicion(5.0, Magnitudes.TEMPERATURA);

	@Test
	public void testColectorTemperatura() {
		this.inicialize();
		assertNotNull(this.colector.getMediator());
		assertNotNull(this.colector.getFrecuencia());
		assertNotNull(this.colector.getDelay());
		assertNotNull(this.colector.getTimer());
		assertNull(this.colector.getValorActual());
		this.clear();
	}

	@Test
	public void testColectar() throws InterruptedException {
		this.inicialize();
		this.colector.colectar();
		this.esperar(this.colector.getFrecuencia());
		assertNotNull(this.colector.getValorActual());

		this.clear();
	}

	@Test
	public void testMedir() {
		this.inicialize();

		assertEquals(this.colector.medir(), medicion);

		this.clear();

	}

	// metodos auxiliares

	private void esperar(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);

	}

	private void inicialize() {
		m = new InstrumentoMediator(Magnitudes.TEMPERATURA);

		medicion = new Medicion(5.0, Magnitudes.TEMPERATURA);
		EstadoVivero.getInstance().setTemperaturaActual(medicion);

		this.colector = new Colector(5000, 0, m);
	}

	private void clear() {
		this.colector.detenerColeccion();
		this.colector = null;
		this.m = null;
	}

}
