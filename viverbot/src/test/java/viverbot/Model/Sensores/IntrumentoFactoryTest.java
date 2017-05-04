package viverbot.Model.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Magnitudes.Magnitudes;
import viverbot.Model.Sensores.InstrumentoFactory;
import viverbot.Model.Sensores.InstrumentoMedicion;
import viverbot.Model.Sensores.Metro;
import viverbot.Model.Sensores.SensorHumedad;
import viverbot.Model.Sensores.SensorTemperatura;

public class IntrumentoFactoryTest {

	private  InstrumentoMedicion instrumentoTest = null;

	@Test
	public void CreatInstrumentoTestTemperatura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitudes.TEMPERATURA);
		assertTrue(instrumentoTest instanceof SensorTemperatura);
		clear();
	}

	@Test
	public void CreatInstrumentoTestHumedad() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitudes.HUMEDAD);
		assertTrue(instrumentoTest instanceof SensorHumedad);
		this.clear();
	}
	
	@Test
	public void CreatInstrumentoTestAltura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		assertTrue(instrumentoTest instanceof Metro);
		this.clear();
	}

	@Test
	public void CreatSingletownTestTemperatura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitudes.TEMPERATURA);
		InstrumentoMedicion aux = InstrumentoFactory.crearInstrumento(Magnitudes.TEMPERATURA);
		assertTrue(instrumentoTest == aux);
		this.clear();
	}
	
	@Test
	public void CreatSingletownTestHumedad() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitudes.HUMEDAD);
		InstrumentoMedicion aux = InstrumentoFactory.crearInstrumento(Magnitudes.HUMEDAD);
		assertTrue(instrumentoTest == aux);
		this.clear();
	}
	
	@Test
	public void CreatSingletownTestAltura() {
		instrumentoTest = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		InstrumentoMedicion aux = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		assertTrue(instrumentoTest == aux);
		this.clear();
	}	

	// metodos auxiliares
	private void clear() {
		instrumentoTest = null;
	}

}