package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Sensores.Metro;
import viverbot.Modelo.Sensores.SensorHumedad;

public class SoporteFactoryTest {
	
	private SoporteMovible soporteTest = null;
	

	@Test
	public void CrearSoporteTestHumedad() {
		this.soporteTest = SoporteFactory.crearSoporte(Magnitud.HUMEDAD);
		assertTrue(this.soporteTest.getColector().getInstrumentoMedicion() instanceof SensorHumedad);
	}
	
	@Test
	public void CrearSoporteTestAltura() {
		this.soporteTest = SoporteFactory.crearSoporte(Magnitud.ALTURA);
		assertTrue(this.soporteTest.getColector().getInstrumentoMedicion() instanceof Metro);
	}
	
	@Test
	public void crearSingletownTestHumedad(){
		this.soporteTest = SoporteFactory.crearSoporte(Magnitud.HUMEDAD);
		SoporteMovible aux = SoporteFactory.crearSoporte(Magnitud.HUMEDAD);
		assertTrue(this.soporteTest == aux);

	}
	
	@Test
	public void crearSingletownTestAltura(){
		this.soporteTest = SoporteFactory.crearSoporte(Magnitud.ALTURA);
		SoporteMovible aux = SoporteFactory.crearSoporte(Magnitud.ALTURA);
		assertTrue(this.soporteTest == aux);

	}

}
