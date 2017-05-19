package viverbot.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import viverbot.Controlador.Verificacion.EvaluaRiego;
import viverbot.Controlador.Verificacion.EvaluaRiegoXTemperatura;
import viverbot.Controlador.Verificacion.RiegoValidable;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class NivelRiegoTest {

	private EvaluaRiegoXTemperatura EvaluaRiegoTempTest=null;
	private EvaluaRiego EvaluaRiegoInicial=null;

	private Medicion temperaturaBaja = new Medicion(5.0,Magnitudes.TEMPERATURA);
	private Medicion temperaturaAlta = new Medicion(25.0,Magnitudes.TEMPERATURA);

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
