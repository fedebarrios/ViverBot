package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Fecha;

public class FechaTest {
	private Fecha fechaTest;

	@Test
	public void CompareToTestFecha() {
		Fecha h1 = new Fecha(1, 4, 2017);
		Fecha h2 = new Fecha(2, 4, 2017);
		Fecha h3 = new Fecha(3, 4, 2017);
		Fecha h4 = new Fecha(3, 4, 2017);
		Fecha h5 = Fecha.obtenerFechaActual();
		Fecha h6= new Fecha(11,4,2017);
		
		System.out.println("Dia: " + h5.getDia() + " Mes: " + h5.getMes() + " Año: " + h5.getAnio());
		
		assertTrue(h5.compareTo(h6) == 1);

		assertFalse(h1.compareTo(h2) == 1);
		assertTrue(h1.compareTo(h2) == -1);
		assertFalse(h1.compareTo(h2) == 0);
		assertTrue(h3.compareTo(h1) == 1);
		assertFalse(h3.compareTo(h1) == 0);
		assertFalse(h3.compareTo(h1) == -1);
		assertTrue(h3.compareTo(h4) == 0);

	}

	@Test
	public void CompareToTestMes() {
		Fecha m1 = new Fecha(1, 20, 2017);
		Fecha m2 = new Fecha(1, 30, 2017);
		Fecha m3 = new Fecha(1, 20, 2017);

		assertTrue(m1.compareTo(m2) == -1);
		assertFalse(m1.compareTo(m2) == 0);
		assertFalse(m1.compareTo(m2) == 1);
		assertTrue(m2.compareTo(m1) == 1);
		assertFalse(m2.compareTo(m1) == 0);
		assertFalse(m2.compareTo(m1) == -1);

		assertTrue(m1.compareTo(m3) == 0);

	}

	@Test
	public void CompareToTestAnio() {
		Fecha s1 = new Fecha(1, 1, 2016);
		Fecha s2 = new Fecha(1, 1, 2017);
		Fecha s3 = new Fecha(1, 1, 2016);

		assertTrue(s1.compareTo(s2) == -1);
		assertFalse(s1.compareTo(s2) == 0);
		assertFalse(s1.compareTo(s2) == 1);
		assertTrue(s2.compareTo(s1) == 1);
		assertFalse(s2.compareTo(s1) == 0);
		assertFalse(s2.compareTo(s1) == -1);

		assertTrue(s1.compareTo(s3) == 0);

	}
	
	@Test
	public void CompareToTest() {
		Fecha m1 = new Fecha(1, 30, 2015);
		Fecha m2 = new Fecha(1, 31, 2016);
		Fecha m3 = new Fecha(2, 27, 2017);
		Fecha m4 = new Fecha(2, 27, 2017);


		assertTrue(m1.compareTo(m2) == -1);
		assertFalse(m1.compareTo(m2) == 0);
		assertFalse(m1.compareTo(m2) == 1);
		
		assertTrue(m3.compareTo(m1) == 1);
		assertFalse(m3.compareTo(m1) == 0);
		assertFalse(m3.compareTo(m1) == -1);
		
		assertTrue(m3.compareTo(m4) == 0);


	}


}
