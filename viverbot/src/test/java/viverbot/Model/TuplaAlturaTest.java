package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Altura;

public class TuplaAlturaTest {
	
	@Test
	public void testTuplaAltura(){
		TuplaAltura tupla = new TuplaAltura(new Altura(14,"cm"),1);
		assertTrue(tupla.getAltura() instanceof Altura);
		assertTrue(tupla.getAltura().getCentimetros()==14);
		assertTrue(tupla.getDiaDeVida()==1);
		tupla.setAltura(new Altura(6,"cm"));
		tupla.setDiaDeVida(5);
		assertTrue(tupla.getAltura() instanceof Altura);
		assertTrue(tupla.getAltura().getCentimetros()==6);
		assertFalse(tupla.getAltura().getCentimetros()==15);
		assertTrue(tupla.getDiaDeVida()==5);
	}
	
}
