package viverbot.Modelo.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Sensores.Metro;

public class MetroTest {
	private Metro metro;
	private Medicion m;
	
	@Test (expected = Exception.class)
	public void metroRoto() throws Exception{
		metro = new Metro();
		metro.simularMedicion(2);
	}
	
	@Test 
	public void metroDevuelveMedicion() throws Exception{
		metro = new Metro();
		Medicion medicion = metro.simularMedicion(88);
		assertTrue(medicion.getTipo().equals(Magnitud.ALTURA));
	}
}
