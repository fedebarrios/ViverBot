package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;

public class Potencia_0Test {

	@Test
	public void aplicarPotencia_recibeEstadoCalor_subeLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		aire.setFrioCalorEstado(new Calor());
		Temperatura temp = new Temperatura(15.0);
		Potencia_0 pote = new Potencia_0();
		Temperatura ret = pote.aplicarPotencia(aire, temp);
		Temperatura aux = new Temperatura(15.05);
		assertEquals(aux.getValor(), ret.getValor());
	}

	@Test
	public void aplicarPotencia_recibeEstadoFrio_bajaLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		aire.setFrioCalorEstado(new Frio());
		Temperatura temp = new Temperatura(15.0);
		Potencia_0 pote = new Potencia_0();
		Temperatura ret = pote.aplicarPotencia(aire, temp);
		Temperatura aux = new Temperatura(14.95);
		assertEquals(aux.getValor(), ret.getValor());
	}

}
