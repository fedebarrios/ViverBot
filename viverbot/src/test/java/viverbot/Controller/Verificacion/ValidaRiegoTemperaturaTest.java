package viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.RiegoValidable;
import viverbot.Controlador.Verificacion.EvaluaRiego;
import viverbot.Controlador.Verificacion.EvaluaRiegoXTemperatura;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;

public class ValidaRiegoTemperaturaTest {

	private EvaluaRiegoXTemperatura validaRiegoTempTest=null;
	private Temperatura temperaturaOptima = new Temperatura(15.0);
	private Temperatura temperaturaBaja = new Temperatura(5.0);
	private Temperatura temperaturaAlta = new Temperatura(25.0);

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.validaRiegoTempTest.getTransmTempActual() != null);
		this.clear();

	}

	@Test
	public void AnalizarOptimoTest() {
		this.inicialize();
		Temperatura tO= validaRiegoTempTest.getTransmTempActual().getTemperaturaActual(); 
		assertTrue(!tO.equals(temperaturaOptima));

	}
	
	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
		Temperatura tO= validaRiegoTempTest.getTransmTempActual().getTemperaturaActual(); 		
		assertTrue(!tO.equals(temperaturaBaja));

	}
	
	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
		Temperatura tO= validaRiegoTempTest.getTransmTempActual().getTemperaturaActual(); 		
		assertTrue(tO.equals(temperaturaAlta));
	}
	
	

	// metodos auxiliares

	private void inicialize() {
		RiegoValidable rv= new EvaluaRiego();
		validaRiegoTempTest=new EvaluaRiegoXTemperatura(rv);

	}

	private void clear() {
		this.validaRiegoTempTest = null;
	}
}
