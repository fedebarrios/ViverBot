package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Potencia_0;

public class Potencia_1Test {

	@Test
	public void aplicarPotenciaTest() {
		AireAcondicionado aire = new AireAcondicionado();
		aire.setFrioCalorEstado(new Calor());
		Potencia_0 pote = new Potencia_0();
		Medicion ret = pote.aplicarPotencia(aire);
		Double expected = 0.1;
		assertEquals(expected, ret.getValor());
	}

}
