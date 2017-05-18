package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Potencia_0;

public class Potencia_0Test {
	AireAcondicionado aire;
	Potencia_0 pote;

	@Test
	public void aplicarPotenciaTest() {
		init();
		aire.setEstado(new Calor());
		Medicion ret = pote.aplicarPotencia(aire);
		Double expected = 0.003;
		assertEquals(expected, ret.getValor());
	}

	@Test
	public void toStringTest() {
		init();
		String ret = pote.toString();
		String expected = "0";
		assertEquals(expected, ret);
	}

	public void init() {
		aire = new AireAcondicionado();
		pote = new Potencia_0();
	}

}
