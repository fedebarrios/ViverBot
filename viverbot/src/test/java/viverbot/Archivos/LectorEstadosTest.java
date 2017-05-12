package viverbot.Archivos;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

public class LectorEstadosTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	LectorEstados lector;
	
	@Test
	public void testArchivoNoTxt()
	{
		inicialize("src/test/java/viverbot/Archivos/File.notxt");
		assertThat(outContent.toString(), containsString("La extension del archivo no es .txt."));
		clear();
	}
	
	@Test
	public void testArchivoNoEncontrado()
	{
		inicialize("src/test/java/viverbot/Archivos/FixleDoxsEstadxxosMenoxs.txt");
		assertThat(outContent.toString(), containsString("No existe archivo."));
		clear();
	}
	
	
	@Test
	public void testArchivoOK()
	{
		inicialize("src/test/java/viverbot/Archivos/FileNoNumerico.txt");
		assertThat(outContent.toString(), containsString(""));
		clear();
	}
	
	private void inicialize(String archivo) {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		lector = new LectorEstados();
		lector.leerArchivo(archivo);
	}

	private void clear() {
	}

}
