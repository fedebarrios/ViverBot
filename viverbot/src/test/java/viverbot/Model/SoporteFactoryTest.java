package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Model.Magnitudes.Magnitudes;
import viverbot.Model.Sensores.Metro;
import viverbot.Model.Sensores.SensorHumedad;

public class SoporteFactoryTest {
	
	private SoporteMovible soporteTest = null;
	

	@Test
	public void CrearSoporteTestHumedad() {
		this.soporteTest = SoporteFactory.crearSoporte(Magnitudes.HUMEDAD);
		assertTrue(this.soporteTest.getColector().getInstrumentoMedicion() instanceof SensorHumedad);
	}
	
	@Test
	public void CrearSoporteTestAltura() {
		this.soporteTest = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
		assertTrue(this.soporteTest.getColector().getInstrumentoMedicion() instanceof Metro);
	}
	
	@Test
	public void crearSingletownTestHumedad(){
		this.soporteTest = SoporteFactory.crearSoporte(Magnitudes.HUMEDAD);
		SoporteMovible aux = SoporteFactory.crearSoporte(Magnitudes.HUMEDAD);
		assertTrue(this.soporteTest == aux);

	}
	
	@Test
	public void crearSingletownTestAltura(){
		this.soporteTest = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
		SoporteMovible aux = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
		assertTrue(this.soporteTest == aux);

	}

}
