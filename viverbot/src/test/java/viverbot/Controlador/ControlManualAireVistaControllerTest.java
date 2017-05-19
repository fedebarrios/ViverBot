package viverbot.Controlador;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Potencia_0;

public class ControlManualAireVistaControllerTest {
	private ControlManualAireVistaController controlador;
	private AireAcondicionado aire;

	@Test
	public void test() {
		init();
		controlador.mostrar();
		assertEquals(new Calor().getClass(), aire.getEstado().getClass());
		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
		assertEquals("26", aire.getTemp().toString());
	}

	public void init() {
		this.aire = new AireAcondicionado();
		this.controlador = new ControlManualAireVistaController(aire);
	}

	public void clear(){
		this.aire = null;
		this.controlador = null;
	}

}
