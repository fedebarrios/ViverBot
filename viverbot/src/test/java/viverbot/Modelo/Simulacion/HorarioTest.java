package viverbot.Modelo.Simulacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.Hora;


public class HorarioTest {

	
	@Test
	public void testGetHorarioMedianoche() {
		Hora  h0 = new Hora(0,0,0);
		Hora  h1 = new Hora(1,0,0);
		Hora  h2 = new Hora(2,0,0);

		assertEquals(Horario.MEDIANOCHE, Horario.getHorario(h0));
		assertEquals(Horario.MEDIANOCHE, Horario.getHorario(h1));
		assertEquals(Horario.MEDIANOCHE, Horario.getHorario(h2));

		
	}
	@Test
	public void testGetHorarioMadrugada() {
		Hora  h0 = new Hora(3,0,0);
		Hora  h1 = new Hora(4,0,0);
		Hora  h2 = new Hora(5,0,0);

		assertEquals(Horario.MADRUGADA, Horario.getHorario(h0));
		assertEquals(Horario.MADRUGADA, Horario.getHorario(h1));
		assertEquals(Horario.MADRUGADA, Horario.getHorario(h2));		
	}@Test
	public void testGetHorarioAmanecer() {
		Hora  h0 = new Hora(6,0,0);
		Hora  h1 = new Hora(7,0,0);
		Hora  h2 = new Hora(8,0,0);

		assertEquals(Horario.AMANECER, Horario.getHorario(h0));
		assertEquals(Horario.AMANECER, Horario.getHorario(h1));
		assertEquals(Horario.AMANECER, Horario.getHorario(h2));		
	}@Test
	public void testGetHorarioMañana() {
		Hora  h0 = new Hora(9,0,0);
		Hora  h1 = new Hora(10,0,0);
		Hora  h2 = new Hora(11,0,0);

		assertEquals(Horario.MAÑANA, Horario.getHorario(h0));
		assertEquals(Horario.MAÑANA, Horario.getHorario(h1));
		assertEquals(Horario.MAÑANA, Horario.getHorario(h2));		
	}@Test
	public void testGetHorarioMediodia() {
		Hora  h0 = new Hora(12,0,0);
		Hora  h1 = new Hora(13,0,0);
		Hora  h2 = new Hora(14,0,0);

		assertEquals(Horario.MEDIODIA, Horario.getHorario(h0));
		assertEquals(Horario.MEDIODIA, Horario.getHorario(h1));
		assertEquals(Horario.MEDIODIA, Horario.getHorario(h2));		
	}@Test
	public void testGetHorarioTarde() {
		Hora  h0 = new Hora(15,0,0);
		Hora  h1 = new Hora(16,0,0);
		Hora  h2 = new Hora(17,0,0);

		assertEquals(Horario.TARDE, Horario.getHorario(h0));
		assertEquals(Horario.TARDE, Horario.getHorario(h1));
		assertEquals(Horario.TARDE, Horario.getHorario(h2));			
	}@Test
	public void testGetHorarioAtardecer() {
		Hora  h0 = new Hora(18,0,0);
		Hora  h1 = new Hora(19,0,0);
		Hora  h2 = new Hora(20,0,0);

		assertEquals(Horario.ATARDECER, Horario.getHorario(h0));
		assertEquals(Horario.ATARDECER, Horario.getHorario(h1));
		assertEquals(Horario.ATARDECER, Horario.getHorario(h2));		
	}@Test
	public void testGetHorarioNoche() {
		Hora  h0 = new Hora(21,0,0);
		Hora  h1 = new Hora(22,0,0);
		Hora  h2 = new Hora(23,0,0);

		assertEquals(Horario.NOCHE, Horario.getHorario(h0));
		assertEquals(Horario.NOCHE, Horario.getHorario(h1));
		assertEquals(Horario.NOCHE, Horario.getHorario(h2));		
	}

}
