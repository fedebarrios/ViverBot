package viverbot.Controlador.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.RiegoValidable;
import viverbot.Model.NivelRiego;
import viverbot.Controlador.Verificacion.EvaluaRiego;
import viverbot.Controlador.Verificacion.EvaluaRiegoXHumedad;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class EvaluaRiegoHumedadTest {

	private EvaluaRiegoXHumedad evaluaRiegoHumedadTest=null;
	private EvaluaRiego evaluaRiegoInicial=null;

	private Medicion humedadBaja = new Medicion(30.0,Magnitudes.HUMEDAD);
	private Medicion humedadAlta = new Medicion(60.0,Magnitudes.HUMEDAD);

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.evaluaRiegoHumedadTest.getMedicionHumedad() != null);
		this.clear();

	}

	
	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
		evaluaRiegoHumedadTest.setMedicionHumedad(humedadBaja);
				
		assertEquals(evaluaRiegoHumedadTest.cantidadOptimaRiego(),evaluaRiegoInicial.cantidadOptimaRiego().aumentar());

	}
	
	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
		evaluaRiegoHumedadTest.setMedicionHumedad(humedadAlta);
		assertEquals(evaluaRiegoHumedadTest.cantidadOptimaRiego(),NivelRiego.NIVELNULO);
	}
	
	

	// metodos auxiliares

	private void inicialize() {
		RiegoValidable rv= new EvaluaRiego();
		evaluaRiegoInicial=new EvaluaRiego();
		evaluaRiegoHumedadTest=new EvaluaRiegoXHumedad(rv);


		
	}

	private void clear() {
		this.evaluaRiegoHumedadTest = null;
	}
}
