package viverbot.Modelo.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class DiagnosticoAnalisisTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void diagnosticoEquals(){
		DiagnosticoAnalisis d1 = new DiagnosticoAnalisis(new Medicion(14.4, Magnitud.TEMPERATURA), true,0.0);
		DiagnosticoAnalisis d3 = new DiagnosticoAnalisis(new Medicion(16.1, Magnitud.TEMPERATURA), false,0.0);
		assertFalse(d1.equals(d3));
		assertEquals(0,  d1.getDiferencia().doubleValue(),0);
		assertEquals(14.4,  d1.getValor().getValor().doubleValue(),0);
		assertTrue(d1.getOptima());
		
		
	}

}
