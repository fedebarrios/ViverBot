package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_1;

public class Potencia_1Test {

	@Test
	public void aplicarPotencia_recibeEstadoCalor_subeLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		aire.setFrioCalorEstado(new Calor());
		Temperatura temp = new Temperatura(15.0);
		Potencia_1 pote = new Potencia_1();
		Temperatura ret = pote.aplicarPotencia(aire, temp);
		Temperatura aux = new Temperatura(15.1);
		assertEquals(aux.getValor(), ret.getValor());
	}

	@Test
	public void aplicarPotencia_recibeEstadoFrio_bajaLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		aire.setFrioCalorEstado(new Frio());
		Temperatura temp = new Temperatura(15.0);
		Potencia_1 pote = new Potencia_1();
		Temperatura ret = pote.aplicarPotencia(aire, temp);
		Temperatura aux = new Temperatura(14.9);
		assertEquals(aux.getValor(), ret.getValor());
	}

}
