package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Frio;

public class FrioTest {

	@Test
	public void anunciarEstadoTest() {
		AireAcondicionado aire = new AireAcondicionado();
		Frio frio = new Frio();
		frio.definirEstado(aire);
		assertEquals(Frio.class, aire.getEstado().getClass());
	}
	
	@Test
	public void toStringTest() {
		Frio frio = new Frio();
		String ret = frio.toString();
		String expected = "Frio";
		assertEquals(expected, ret);
	}
}
