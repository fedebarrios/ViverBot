package viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UbicacionTest {
	
	@Test
	public void ubicacionTest(){
		Ubicacion u = new Ubicacion();
		assertEquals(50 , u.obtenerUbicaciones().size());
	}
}
