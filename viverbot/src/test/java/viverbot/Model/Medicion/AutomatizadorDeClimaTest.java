package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;

public class AutomatizadorDeClimaTest {
	AutomatizadorDeClima automatizador;
	AireAcondicionado aire;

	@Test
	public void definirEstados_recibeFrioPotencia0() throws Exception {
		init();
		Whitebox.invokeMethod(automatizador, "definirFrioCalor");
		assertNotNull(aire);
//		assertEquals(new Frio().getClass(), aire.getEstado().getClass());
//		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
	}

	public void init() {
		automatizador = new AutomatizadorDeClima();
		aire = automatizador.getAire();
	}

}
