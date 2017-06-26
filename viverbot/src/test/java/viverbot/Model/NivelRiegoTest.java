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

	NivelRiego nivelRiegoTest =null;
	NivelRiego nivelRiegoMaxTest =NivelRiego.NIVEL5;
	NivelRiego nivelRiegoMinTest =NivelRiego.NIVEL1;

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.nivelRiegoTest != null);
		this.clear();
	}
	
	@Test
	public void AnalizarBajarTest() {
		this.inicialize();
		assertEquals(nivelRiegoTest.bajar(),NivelRiego.NIVEL2);
	}
	
	@Test
	public void AnalizarAumentarTest() {
		this.inicialize();
		assertEquals(nivelRiegoTest.aumentar(),NivelRiego.NIVEL4);
	}
	
	@Test
	public void AnalizarAumentarMaxTest() {
		this.inicialize();
		assertEquals(nivelRiegoMaxTest.aumentar(),NivelRiego.NIVEL5);
	}

	@Test
	public void AnalizarBajarMinTest() {
		this.inicialize();
		assertEquals(nivelRiegoMinTest.bajar(),NivelRiego.NIVEL1);
	}
	
	@Test
	public void AnalizarNuloBajarTest() {
		this.inicialize();
		nivelRiegoTest=NivelRiego.NIVELNULO;
		assertEquals(nivelRiegoTest.bajar(),NivelRiego.NIVELNULO);
	}

	@Test
	public void AnalizarNuloAumentarTest() {
		this.inicialize();
		nivelRiegoTest=NivelRiego.NIVELNULO;
		assertEquals(nivelRiegoTest.aumentar(),NivelRiego.NIVELNULO);
	}	
	
	
	// metodos auxiliares

	private void inicialize() {
		nivelRiegoTest =NivelRiego.NIVEL3;
		
	}

	private void clear() {
		nivelRiegoTest = null;
		
	}

}
