package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;

public class CalorTest {

	@Test
	public void anunciarEstadoTest() {
		AireAcondicionado aire = new AireAcondicionado();
		Calor calor = new Calor();
		calor.definirEstado(aire);
		assertEquals(Calor.class, aire.getEstado().getClass());
	}
	
	@Test
	public void toStringTest() {
		Calor calor = new Calor();
		String ret = calor.toString();
		String expected = "Calor";
		assertEquals(expected, ret);
	}

}
