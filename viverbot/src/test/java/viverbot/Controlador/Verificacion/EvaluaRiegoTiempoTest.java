package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.ControlTiempo;
import viverbot.Controlador.Verificacion.RiegoValidable;
import viverbot.Controlador.Verificacion.EvaluaRiego;
import viverbot.Controlador.Verificacion.EvaluaRiegoXTiempo;
import viverbot.Model.Fecha;
import viverbot.Model.Hora;
public class EvaluaRiegoTiempoTest {

	private EvaluaRiegoXTiempo validaRiegoTiempoTest=null;
	private EvaluaRiego EvaluaRiegoInicial=null;

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.validaRiegoTiempoTest.getControlTiempo() != null);
		this.clear();

	}

	@Test
	public void ValidaAltoTest() {
		this.inicialize();
		Fecha f=new Fecha(16,01,1986);
		Hora h=new Hora(15,00,00);
		ControlTiempo t1 = new ControlTiempo(f,h);
		validaRiegoTiempoTest.setControlTiempo(t1);
		
		assertTrue(validaRiegoTiempoTest.getControlTiempo().esVerano());
		assertTrue(validaRiegoTiempoTest.getControlTiempo().esDeDia());
		assertEquals(validaRiegoTiempoTest.cantidadOptimaRiego(),EvaluaRiegoInicial.cantidadOptimaRiego().aumentar());
		
	}

	
	@Test
	public void ValidaBajoTest() {
		this.inicialize();
		Fecha f=new Fecha(16,07,1986);
		Hora h=new Hora(22,00,00);

		ControlTiempo t1 = new ControlTiempo(f,h);
		validaRiegoTiempoTest.setControlTiempo(t1);
		
		assertTrue(validaRiegoTiempoTest.getControlTiempo().esInvierno());
		assertFalse(validaRiegoTiempoTest.getControlTiempo().esDeDia());
		assertEquals(validaRiegoTiempoTest.cantidadOptimaRiego(),EvaluaRiegoInicial.cantidadOptimaRiego().bajar());
			
	}

	
	
	

	// metodos auxiliares

	private void inicialize() {
		RiegoValidable rv= new EvaluaRiego();
		EvaluaRiegoInicial=new EvaluaRiego();
		validaRiegoTiempoTest=new EvaluaRiegoXTiempo(rv);

	}

	private void clear() {
		this.validaRiegoTiempoTest = null;
	}
}
