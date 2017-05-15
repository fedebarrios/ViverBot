package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class LecturaArchivoTest {
	
	@Test
	public void testLecturaExitosa() throws Exception
	{
		LectorHistorial lector = new LectorHistorial();
		List<String> lectura = lector.leerArchivo("src/test/java/viverbot/Archivos/Historial.txt");
		assertEquals(4,lectura.size());
		assertEquals("ezanahoria:zanahorius",lectura.get(3));
		assertEquals("h1:2.4",lectura.get(0));
		
	}

}
