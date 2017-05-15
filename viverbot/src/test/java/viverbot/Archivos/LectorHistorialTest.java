package viverbot.Archivos;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class LectorHistorialTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	LectorHistorial lector;
	
	@Test (expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/Historial.t");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("No existe archivo"));

	}
	
	@Test (expected = Exception.class)
	public void testArchivoNoTxt() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/Historial.csb");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("La extension del archivo no es .txt."));
	}
	
	private void inicialize(String archivo) throws Exception{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		lector = new LectorHistorial();
		lector.leerArchivo(archivo);
	}
}
