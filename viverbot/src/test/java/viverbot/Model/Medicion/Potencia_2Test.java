package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Potencia_2;

public class Potencia_2Test {
	AireAcondicionado aire;
	Potencia_2 pote;

	@Test
	public void aplicarPotenciaTest() {
		init();
		aire.setEstado(new Calor());
		Medicion ret = pote.aplicarPotencia(aire);
		Double expected = 0.010;
		assertEquals(expected, ret.getValor());
	}

	@Test
	public void toStringTest() {
		init();
		String ret = pote.toString();
		String expected = "2";
		assertEquals(expected, ret);
	}

	public void init() {
		aire = new AireAcondicionado();
		pote = new Potencia_2();
	}

}
