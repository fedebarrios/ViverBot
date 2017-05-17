package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Potencia_3;

public class Potencia_3Test {
	AireAcondicionado aire;
	Potencia_3 pote;

	@Test
	public void aplicarPotenciaTest() {
		init();
		aire.setEstado(new Calor());
		Medicion ret = pote.aplicarPotencia(aire);
		Double expected = 0.013;
		assertEquals(expected, ret.getValor());
	}

	@Test
	public void toStringTest() {
		init();
		String ret = pote.toString();
		String expected = "Potencia 3";
		assertEquals(expected, ret);
	}

	public void init() {
		aire = new AireAcondicionado();
		pote = new Potencia_3();
	}
}
