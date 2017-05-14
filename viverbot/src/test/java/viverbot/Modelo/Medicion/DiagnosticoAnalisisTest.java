package viverbot.Modelo.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class DiagnosticoAnalisisTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void diagnosticoEquals(){
		DiagnosticoAnalisis d1 = new DiagnosticoAnalisis(new Medicion(14.4, Magnitudes.TEMPERATURA), true);
		DiagnosticoAnalisis d3 = new DiagnosticoAnalisis(new Medicion(16.1, Magnitudes.TEMPERATURA), false);
		assertFalse(d1.equals(d3));
		assertEquals(0,  d1.getDiferencia().doubleValue(),4);
		assertEquals(14.4,  d1.getMagnitud().getValor().doubleValue(),4);
		assertTrue(d1.getOptima());
		
		d1.setDiferencia(4.0);
		d1.setOptima(false);
		d1.setTemperatura(new Medicion(60.0,Magnitudes.TEMPERATURA));
		assertEquals(4.0,  d1.getDiferencia().doubleValue(),4);
		assertEquals(60.0,  d1.getMagnitud().getValor().doubleValue(),4);
		assertFalse(d1.getOptima());
	}

}
