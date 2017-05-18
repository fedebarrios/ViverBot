package viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class MedicionTest {

	@Test
	public void TestTemperatura() {
		Medicion t1 = new Medicion(9.0, Magnitudes.TEMPERATURA);
		Medicion t2 = new Medicion(9.0, Magnitudes.TEMPERATURA);
		Medicion t3 = new Medicion(9.0, Magnitudes.HUMEDAD);
		Medicion t4 = new Medicion(10.0, Magnitudes.TEMPERATURA);
		Medicion t5 = new Medicion(10.0, Magnitudes.HUMEDAD);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

	@Test
	public void TestHumedad() {
		Medicion t1 = new Medicion(9.0, Magnitudes.HUMEDAD);
		Medicion t2 = new Medicion(9.0, Magnitudes.HUMEDAD);
		Medicion t3 = new Medicion(9.0, Magnitudes.ALTURA);
		Medicion t4 = new Medicion(10.0, Magnitudes.HUMEDAD);
		Medicion t5 = new Medicion(10.0, Magnitudes.TEMPERATURA);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

	@Test
	public void TestAltura() {
		Medicion t1 = new Medicion(9.0, Magnitudes.ALTURA);
		Medicion t2 = new Medicion(9.0, Magnitudes.ALTURA);
		Medicion t3 = new Medicion(9.0, Magnitudes.TEMPERATURA);
		Medicion t4 = new Medicion(10.0, Magnitudes.ALTURA);
		Medicion t5 = new Medicion(10.0, Magnitudes.HUMEDAD);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
		assertFalse(t1.equals(t4));
		assertFalse(t1.equals(t5));

	}

	@Test
	public void TestsetTemperatura() {
		Medicion t1 = new Medicion(9.0, Magnitudes.ALTURA);
		t1.setValor(10.0);
		assertEquals(t1.getValor(), new Double(10.0));
		assertNotEquals(t1.getValor(), 9.0);

	}
	
	@Test
	public void TestEqualsNotInstance() {
		Medicion t1 = new Medicion(9.0, Magnitudes.ALTURA);
		Object o = new Object();
		assertNotEquals(t1, o);

	}
	
	@Test
	public void TestEmptyMedicion() {
		Medicion t1 = new EmptyMedicion();
		assertEquals(t1.getValor(), new Double(0.0));
		assertEquals(t1.getTipo(), Magnitudes.VACIO);

	}

}
