package viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controller.Verificacion.ControlTiempo;
import viverbot.Controller.Verificacion.RiegoValidable;
import viverbot.Controller.Verificacion.ValidaRiego;
import viverbot.Controller.Verificacion.ValidaRiegoTiempo;
import viverbot.Model.Estacion;
import viverbot.Model.RangoNumerico;
import viverbot.Model.Magnitudes.Temperatura;

public class ValidaRiegoTiempoTest {

	private ValidaRiegoTiempo validaRiegoTiempoTest=null;

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.validaRiegoTiempoTest.getControlTiempo() != null);
		this.clear();

	}

	@Test
	public void AnalizarVeranoDiaTest() {
		this.inicialize();
		ControlTiempo t1 = new ControlTiempo();
		
		if (t1.esVerano()){
			assertTrue(validaRiegoTiempoTest.getControlTiempo().esVerano());
			if (t1.esDeDia())
				assertTrue(validaRiegoTiempoTest.getControlTiempo().esDeDia());
		}
	}
	
	@Test
	public void AnalizarInviernoNocheTest() {
		this.inicialize();
		ControlTiempo t1 = new ControlTiempo();
		
		if (t1.esInvierno()){
			assertTrue(validaRiegoTiempoTest.getControlTiempo().esInvierno());
			if (t1.esDeDia())
				assertFalse(validaRiegoTiempoTest.getControlTiempo().esDeDia());
		}

	}
	
	
	

	// metodos auxiliares

	private void inicialize() {
		RiegoValidable rv= new ValidaRiego();
		validaRiegoTiempoTest=new ValidaRiegoTiempo(rv);

	}

	private void clear() {
		this.validaRiegoTiempoTest = null;
	}
}
