package viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Altura;

public class AlturaTest {

	@SuppressWarnings("deprecation")
	@Test
	public void AlturaTest(){
		Altura altura1 = new Altura(0.69,"m");
		assertTrue(altura1.getCentimetros() == 69.0);
		
		Altura altura2 = new Altura(134,"cm");
		assertTrue(altura2.getMetros() == 1.34);
		
		Altura altura3 = new Altura(14.5,"p");
		assertTrue(altura3.getCentimetros()==36.83);
		
		Altura altura4 = new Altura(14,"j");
		assertTrue(altura4.getCentimetros()==0&&altura4.getMetros()==0&&altura4.getPulgadas()==0);
	}
}
