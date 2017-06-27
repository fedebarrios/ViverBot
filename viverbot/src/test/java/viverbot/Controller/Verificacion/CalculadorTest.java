package viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.CalculadorAlturaFutura;
import viverbot.Model.RegistroHistorial;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class CalculadorTest {
	
	@Test
	public void CalculadorTest(){
		CalculadorAlturaFutura c = CalculadorAlturaFutura.getInstance();
		assertEquals(16.0 , c.calcular(new RegistroHistorial(new Medicion(140.0,Magnitud.ALTURA),50), 3, 124.0), 0);
		assertEquals(0.0 , c.calcular(new RegistroHistorial(new Medicion(140.0,Magnitud.ALTURA),50), 3, 150.0), 0);
	} 
}
