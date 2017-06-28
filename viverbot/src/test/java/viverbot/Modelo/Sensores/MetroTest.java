package viverbot.Modelo.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Sensores.Metro;

public class MetroTest {
	private Metro metro;
	
	@Test (expected = Exception.class)
	public void metroRoto() throws Exception{
		metro = new Metro();
		metro.setProbabilidadRomperse(2);
		metro.simularMedicion();
	}
	
	@Test 
	public void metroDevuelveMedicion() throws Exception{
		metro = new Metro();
		metro.setProbabilidadRomperse(88);
		for(int i = 0 ; i < 20 ; i++) {
			Medicion medicion = metro.getMedicion();
			assertTrue(medicion.getTipo().equals(Magnitud.ALTURA));
		}
	}
	
	@Test
	public void metroDevuelveEmptyMedicion() throws Exception{
		metro = new Metro();
		metro.setProbabilidadRomperse(2);
		assertTrue(metro.getMedicion() instanceof EmptyMedicion);
	}
	
}
