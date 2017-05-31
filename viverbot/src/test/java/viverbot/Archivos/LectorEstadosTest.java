package viverbot.Archivos;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

public class LectorEstadosTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	LectorArchivo lector;
	
	@Test (expected = Exception.class)
	public void testArchivoNoTxt() throws Exception
	{
		try{
			inicialize("src/test/java/viverbot/Archivos/File.notxt");
		}
		catch (Exception ex){
			assertThat(ex.getMessage(), containsString("La extension del archivo no es .txt."));
		}
		clear();
	}

	@Test (expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception
	{	
		try{
			inicialize("src/test/java/viverbot/Archivos/FixleDoxsEstadxxosMenoxs.txt");
		}
		catch (Exception ex){
			assertThat(ex.getMessage(), containsString("No existe archivo."));
		}
		clear();
	}
	
	@Test
	public void testArchivoOK() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileNoNumerico.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		clear();
	}
	
	private void inicialize(String archivo) throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		lector = new LectorArchivo();
		lector.leerArchivo(archivo);
	}

	private void clear() {
	}

}
