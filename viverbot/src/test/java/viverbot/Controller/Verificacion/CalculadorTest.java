package viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.CalculadorAlturaFutura;
import viverbot.Model.TuplaAltura;
import viverbot.Modelo.Magnitudes.Altura;

public class CalculadorTest {
	
	@Test
	public void CalculadorTest(){
		CalculadorAlturaFutura c = CalculadorAlturaFutura.getInstance();
		assertEquals(16.0 , c.calcular(new TuplaAltura(new Altura(140,"cm"),50), 3, 124.0), 0);
		assertEquals(0.0 , c.calcular(new TuplaAltura(new Altura(140,"cm"),50), 3, 150.0), 0);
	}
}
