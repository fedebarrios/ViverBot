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
	
	@Test
	public void testArchivoNoEncontrado()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/Historial.t");
		assertThat(outContent.toString(), containsString("No existe archivo"));

	}
	
	@Test
	public void testArchivoNoTxt()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/Historial.csb");
		assertThat(outContent.toString(), containsString("La extension del archivo no es .txt."));
	}
	
	private void inicialize() {
		lector = new LectorHistorial();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
}
