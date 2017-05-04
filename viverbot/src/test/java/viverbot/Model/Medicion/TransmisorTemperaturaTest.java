package viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.Observable;

import org.easymock.EasyMock;
import org.junit.Test;

import viverbot.Model.Magnitudes.Magnitud;
import viverbot.Model.Magnitudes.Temperatura;
import viverbot.Model.Medicion.TransmisorTemperatura;

public class TransmisorTemperaturaTest {

	TransmisorTemperatura trasnmisorTest = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertNotNull(this.trasnmisorTest.getAnalizador());
		this.clear();
	}

//	@Test
//	public void updateTest() throws InterruptedException {
//		this.inicialize();
//
//		ColectorTemperatura colector = new ColectorTemperatura(3000, 0);
//		colector.addObserver(this.trasnmisorTest);
//		colector.colectar();
//		this.esperar(3000);
//		colector.detenerColeccion();
//
//		Magnitud ret = this.trasnmisorTest.getAnalizador().getValorRecibido();
//		assertNotNull(ret);
//		assertTrue(ret.getClass() == Temperatura.class);
//		this.clear();
//	}

	@Test
	public void transmitirTest() throws InterruptedException {
		this.inicialize();
		Temperatura t =  new Temperatura(25.0);
		this.trasnmisorTest.Transmitir(t);
		Magnitud ret = this.trasnmisorTest.getAnalizador().getValorRecibido();
		assertNotNull(ret);
		assertTrue(ret.getClass() == Temperatura.class);
		assertEquals(ret, t);
		this.clear();
	}

	// metodos auxiliares

//	private void esperar(long i) throws InterruptedException {
//		Thread.sleep(i);
//	}

	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperatura();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}

}
