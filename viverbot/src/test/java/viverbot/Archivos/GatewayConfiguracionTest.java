package viverbot.Archivos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GatewayConfiguracionTest {
	
	@Test
	public void setearTest(){
		GatewayConfiguracion.setearDirectorio("c/usuario", 1);
		assertEquals("c/usuario" , GatewayConfiguracion.getDirectorio(1));	

		GatewayConfiguracion.setearDirectorio("c/desktop", 2);
		assertEquals("c/desktop" , GatewayConfiguracion.getDirectorio(2));	

		GatewayConfiguracion.setearDirectorio("c/documents", 3);
		assertEquals("c/documents" , GatewayConfiguracion.getDirectorio(3));	
	}
}
