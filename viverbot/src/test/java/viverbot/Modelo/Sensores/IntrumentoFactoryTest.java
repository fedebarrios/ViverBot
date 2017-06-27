package viverbot.Modelo.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Sensores.InstrumentoFactory;
import viverbot.Modelo.Sensores.Metro;
import viverbot.Modelo.Sensores.SensorHumedad;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Sensores.UnknowInstrumentoMedicion;

public class IntrumentoFactoryTest {

	private  Medir instrumentoTest = null;

	@Test
	public void CreatInstrumentoTestTemperatura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.TEMPERATURA);
		assertTrue(instrumentoTest instanceof SensorTemperatura);
		clear();
	}

	@Test
	public void CreatInstrumentoTestHumedad() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.HUMEDAD);
		assertTrue(instrumentoTest instanceof SensorHumedad);
		this.clear();
	}
	
	@Test
	public void CreatInstrumentoTestAltura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.ALTURA);
		assertTrue(instrumentoTest instanceof Metro);
		this.clear();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void CreatInstrumentoDesconocido() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.VACIO);
		assertTrue(instrumentoTest instanceof UnknowInstrumentoMedicion);
		assertEquals(0.0 , instrumentoTest.getMedicion().getValor().doubleValue(),1);
		this.clear();
	}

	@Test
	public void CreatSingletownTestTemperatura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.TEMPERATURA);
		Medir aux = InstrumentoFactory.crearInstrumento(Magnitud.TEMPERATURA);
		assertTrue(instrumentoTest == aux);
		this.clear();
	}
	
	@Test
	public void CreatSingletownTestHumedad() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.HUMEDAD);
		Medir aux = InstrumentoFactory.crearInstrumento(Magnitud.HUMEDAD);
		assertTrue(instrumentoTest == aux);
		this.clear();
	}
	
	@Test
	public void CreatSingletownTestAltura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitud.ALTURA);
		Medir aux = InstrumentoFactory.crearInstrumento(Magnitud.ALTURA);
		assertTrue(instrumentoTest == aux);
		this.clear();
	}	

	// metodos auxiliares
	private void clear() {
		instrumentoTest = null;
	}

}
