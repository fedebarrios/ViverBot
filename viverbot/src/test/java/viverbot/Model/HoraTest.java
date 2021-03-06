package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Hora;

public class HoraTest {
	private Hora horaTest;

	@Test
	public void CompareToTestHora() {
		Hora h1 = new Hora(12, 0, 0);
		Hora h2 = new Hora(13, 0, 0);
		Hora h3 = new Hora(14, 0, 0);
		Hora h4 = new Hora(14, 0, 0);
		Hora h5 = Hora.obtenerHoraActual();
		Hora h6= new Hora(6,0,0);
		
		//System.out.println("hora: " + h5.getHora() + " minuto: " + h5.getMinuto() + " segundos: " + h5.getSegundo());
		

		assertFalse(h1.compareTo(h2) == 1);
		assertTrue(h1.compareTo(h2) == -1);
		assertFalse(h1.compareTo(h2) == 0);
		assertTrue(h3.compareTo(h1) == 1);
		assertFalse(h3.compareTo(h1) == 0);
		assertFalse(h3.compareTo(h1) == -1);
		assertTrue(h3.compareTo(h4) == 0);

	}

	@Test
	public void CompareToTestMinuto() {
		Hora m1 = new Hora(0, 30, 0);
		Hora m2 = new Hora(0, 40, 0);
		Hora m3 = new Hora(0, 30, 0);

		assertTrue(m1.compareTo(m2) == -1);
		assertFalse(m1.compareTo(m2) == 0);
		assertFalse(m1.compareTo(m2) == 1);
		assertTrue(m2.compareTo(m1) == 1);
		assertFalse(m2.compareTo(m1) == 0);
		assertFalse(m2.compareTo(m1) == -1);

		assertTrue(m1.compareTo(m3) == 0);

	}

	@Test
	public void CompareToTestSegundo() {
		Hora s1 = new Hora(0, 0, 30);
		Hora s2 = new Hora(0, 0, 40);
		Hora s3 = new Hora(0, 0, 30);

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
		Hora m1 = new Hora(12, 30, 4);
		Hora m2 = new Hora(12, 40, 5);
		Hora m3 = new Hora(14, 27, 10);
		Hora m4 = new Hora(14, 27, 10);


		assertTrue(m1.compareTo(m2) == -1);
		assertFalse(m1.compareTo(m2) == 0);
		assertFalse(m1.compareTo(m2) == 1);
		
		assertTrue(m3.compareTo(m1) == 1);
		assertFalse(m3.compareTo(m1) == 0);
		assertFalse(m3.compareTo(m1) == -1);
		
		assertTrue(m3.compareTo(m4) == 0);


	}
	
	@Test
	public void noEquals(){
		Hora h1 = new Hora(12,14,56);
		Hora h2 = new Hora(12,14,54);
		Hora h3 = new Hora(12,14,56);
		Fecha f1 = new Fecha(14,2,2015);
		assertFalse(h1.equals(f1));
		assertFalse(h1.equals(h2));
		assertTrue(h1.equals(h3));
	}
	
	@Test
	public void incrementar(){
		Hora h1 = new Hora(12,14,56);
		h1.incrementarHora(4);
		h1.incrementarSegundos(3);
		h1.incrementraMinuto(14);
		assertEquals(16 , h1.getHora());
		assertEquals(28 , h1.getMinuto());
		assertEquals(59 , h1.getSegundo());
	}
	
	@Test
	public void incrementarMas(){
		Hora h1 = new Hora(22,48,56);
		h1.incrementarHora(4);
		assertEquals(2 , h1.getHora());
		h1.incrementraMinuto(20);
		assertEquals(8 , h1.getMinuto());
		h1.incrementarSegundos(10);
		assertEquals(6 , h1.getSegundo());
	}



}
