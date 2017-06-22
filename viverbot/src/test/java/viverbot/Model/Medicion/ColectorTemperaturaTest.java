package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.EstadoVivero;
import viverbot.Model.Hora;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Medicion.ColectorTemperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Sensores.SensorTemperatura;

import viverbot.Modelo.Simulacion.Simulador;

public class ColectorTemperaturaTest {
	private ColectorTemperatura colector = null;
	private InstrumentoMediator m = null;
	private static final String rangos = "#15,19#10,17#15,20#18,25#25,32#27,35#20,30#17,25#";
	private static final Simulador simulador = new Simulador(Simulador.inicializarRangos(rangos), Magnitudes.TEMPERATURA, 300000);



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

		assertEquals(this.colector.medir(), simulador.getMedicion());

		this.clear();

	}

	// metodos auxiliares

	private void esperar(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);

	}

	private void inicialize() {
		m = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		SensorTemperatura s = (SensorTemperatura) this.m.getInstrumentoMedicion();
		
		s.setSimulador(simulador);
		this.colector = new ColectorTemperatura(5000, 0, m);
	}

	private void clear() {
		this.colector.detenerColeccion();
		this.colector = null;
		this.m = null;
	}

}
