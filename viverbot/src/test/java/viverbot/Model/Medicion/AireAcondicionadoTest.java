package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Potencia_0;

public class AireAcondicionadoTest {

	@Test
	public void getSetTest() {
		AireAcondicionado aire = new AireAcondicionado();
		aire.setFrioCalorEstado(new Calor());
		aire.setPotenciaEstado(new Potencia_0());
		assertNotNull(aire.getFrioCalorEstado());
		assertNotNull(aire.getPotenciaEstado());
		assertEquals(new Potencia_0().getClass(), aire.getPotenciaEstado().getClass());
		assertEquals(new Calor().getClass(), aire.getFrioCalorEstado().getClass());
	}

}
