package viverbot.Archivos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GatewayConfiguracionTest {
	
	@Test
	public void setearTest(){
		GatewayConfiguracion.limpiar();
		GatewayConfiguracion.agregarDirectorio("c/usuario");
		assertEquals(1 , GatewayConfiguracion.getDirectorios().size());	

		GatewayConfiguracion.agregarDirectorio("c/desktop");
		assertEquals(2 , GatewayConfiguracion.getDirectorios().size());	

	}
}
