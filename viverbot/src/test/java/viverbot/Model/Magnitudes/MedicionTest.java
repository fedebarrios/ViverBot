package viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class MedicionTest {

	@Test
	public void TestTemperatura() {
		Medicion t1 =  new Medicion(9.0, Magnitudes.TEMPERATURA);
		Medicion t2 =  new Medicion(9.0, Magnitudes.TEMPERATURA);
		Medicion t3 =  new Medicion(9.0, Magnitudes.HUMEDAD);
		Medicion t4 =  new Medicion(10.0, Magnitudes.TEMPERATURA);
		Medicion t5 =  new Medicion(10.0, Magnitudes.HUMEDAD);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}
	
	@Test
	public void TestHumedad() {
		Medicion t1 =  new Medicion(9.0, Magnitudes.HUMEDAD);
		Medicion t2 =  new Medicion(9.0, Magnitudes.HUMEDAD);
		Medicion t3 =  new Medicion(9.0, Magnitudes.ALTURA);
		Medicion t4 =  new Medicion(10.0, Magnitudes.HUMEDAD);
		Medicion t5 =  new Medicion(10.0, Magnitudes.TEMPERATURA);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}
	
	@Test
	public void TestAltura() {
		Medicion t1 =  new Medicion(9.0, Magnitudes.ALTURA);
		Medicion t2 =  new Medicion(9.0, Magnitudes.ALTURA);
		Medicion t3 =  new Medicion(9.0, Magnitudes.TEMPERATURA);
		Medicion t4 =  new Medicion(10.0, Magnitudes.ALTURA);
		Medicion t5 =  new Medicion(10.0, Magnitudes.HUMEDAD);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

}
