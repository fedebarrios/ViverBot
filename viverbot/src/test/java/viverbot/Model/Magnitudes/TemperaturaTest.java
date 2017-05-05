package viverbot.Model.Magnitudes;

import org.junit.Test;

import junit.framework.TestCase;
import viverbot.Modelo.Magnitudes.Temperatura;

public class TemperaturaTest extends TestCase {

	@Test
	public void testVerificarClase() {
		Temperatura t1 =  new Temperatura(9.0);
		Temperatura t2 =  new Temperatura(9.0);

		assertTrue(t1.getValor() instanceof Double);
		assertTrue(t1.getValor().equals(9.0));
		assertTrue(t1.equals(t2));
		}

}
