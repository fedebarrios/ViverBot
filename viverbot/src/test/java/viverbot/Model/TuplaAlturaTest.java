package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class TuplaAlturaTest {
	
	@Test
	public void testTuplaAltura(){
		RegistroHistorial tupla = new RegistroHistorial(new Medicion(14.0, Magnitudes.ALTURA),1);
		assertTrue(tupla.getAltura() instanceof Medicion);
		assertTrue(tupla.getAltura().getValor()==14.0);
		assertTrue(tupla.getDiaDeVida()==1);
		tupla.setAltura(new Medicion(6.0, Magnitudes.ALTURA));
		tupla.setDiaDeVida(5);
		assertTrue(tupla.getAltura() instanceof Medicion);
		assertTrue(tupla.getAltura().getValor()==6);
		assertFalse(tupla.getAltura().getValor()==15);
		assertTrue(tupla.getDiaDeVida()==5);
	}
	
}
