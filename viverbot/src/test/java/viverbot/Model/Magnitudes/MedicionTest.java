package viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class MedicionTest {

	@Test
	public void TestTemperatura() {
		Medicion t1 = new Medicion(9.0, Magnitud.TEMPERATURA);
		Medicion t2 = new Medicion(9.0, Magnitud.TEMPERATURA);
		Medicion t3 = new Medicion(9.0, Magnitud.HUMEDAD);
		Medicion t4 = new Medicion(10.0, Magnitud.TEMPERATURA);
		Medicion t5 = new Medicion(10.0, Magnitud.HUMEDAD);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

	@Test
	public void TestHumedad() {
		Medicion t1 = new Medicion(9.0, Magnitud.HUMEDAD);
		Medicion t2 = new Medicion(9.0, Magnitud.HUMEDAD);
		Medicion t3 = new Medicion(9.0, Magnitud.ALTURA);
		Medicion t4 = new Medicion(10.0, Magnitud.HUMEDAD);
		Medicion t5 = new Medicion(10.0, Magnitud.TEMPERATURA);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

	@Test
	public void TestAltura() {
		Medicion t1 = new Medicion(9.0, Magnitud.ALTURA);
		Medicion t2 = new Medicion(9.0, Magnitud.ALTURA);
		Medicion t3 = new Medicion(9.0, Magnitud.TEMPERATURA);
		Medicion t4 = new Medicion(10.0, Magnitud.ALTURA);
		Medicion t5 = new Medicion(10.0, Magnitud.HUMEDAD);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

	@Test
	public void TestsetTemperatura() {
		Medicion t1 = new Medicion(9.0, Magnitud.ALTURA);
		t1.setValor(10.0);
		assertEquals(t1.getValor(), new Double(10.0));
		assertNotEquals(t1.getValor(), 9.0);

	}
	
	@Test
	public void TestEqualsNotInstance() {
		Medicion t1 = new Medicion(9.0, Magnitud.ALTURA);
		Object o = new Object();
		assertNotEquals(t1, o);

	}
	
	@Test
	public void TestEmptyMedicion() {
		Medicion t1 = new EmptyMedicion();
		assertEquals(t1.getValor(), new Double(0.0));
		assertEquals(t1.getTipo(), Magnitud.VACIO);

	}

}
