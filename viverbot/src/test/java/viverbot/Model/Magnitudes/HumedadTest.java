package viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Humedad;

public class HumedadTest {

	@Test
	public void testHumedad() {
		Humedad t1 =  new Humedad(9.0);
		Humedad t2 =  new Humedad(9.0);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
	}
	
	

}
