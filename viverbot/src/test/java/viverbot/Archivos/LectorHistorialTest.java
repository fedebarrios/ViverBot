package viverbot.Archivos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class LectorHistorialTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	LectorTxt lector;
	
	@Test (expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/Historial.t");
	}
	
	@Test (expected = Exception.class)
	public void testArchivoNoTxt() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/Historial.csb");
	}
	
	@Test
	public void testLecturaExitosa() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/Historial.txt");	
	}
	
	private void inicialize(String archivo) throws Exception{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		lector = new LectorTxt();
		lector.leerTxt(archivo);
	}
}
