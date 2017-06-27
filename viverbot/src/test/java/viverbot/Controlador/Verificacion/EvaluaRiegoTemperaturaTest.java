package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.RiegoValidable;
import viverbot.Controlador.Verificacion.EvaluaRiego;
import viverbot.Controlador.Verificacion.EvaluaRiegoXTemperatura;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class EvaluaRiegoTemperaturaTest {

	private EvaluaRiegoXTemperatura EvaluaRiegoTempTest=null;
	private EvaluaRiego EvaluaRiegoInicial=null;

	private Medicion temperaturaBaja = new Medicion(5.0,Magnitud.TEMPERATURA);
	private Medicion temperaturaAlta = new Medicion(25.0,Magnitud.TEMPERATURA);

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.EvaluaRiegoTempTest.getTemperaturaActual() != null);
		this.clear();

	}

	
	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
		EvaluaRiegoTempTest.setTemperaturaActual(temperaturaBaja);
				
		assertEquals(EvaluaRiegoTempTest.cantidadOptimaRiego(),EvaluaRiegoInicial.cantidadOptimaRiego().bajar());

	}
	
	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
		EvaluaRiegoTempTest.setTemperaturaActual(temperaturaAlta);
		
		assertEquals(EvaluaRiegoTempTest.cantidadOptimaRiego(),EvaluaRiegoInicial.cantidadOptimaRiego().aumentar());
	}
	
	

	// metodos auxiliares

	private void inicialize() {
		RiegoValidable rv= new EvaluaRiego();
		EvaluaRiegoInicial=new EvaluaRiego();
		EvaluaRiegoTempTest=new EvaluaRiegoXTemperatura(rv);


		
	}

	private void clear() {
		this.EvaluaRiegoTempTest = null;
	}
}
