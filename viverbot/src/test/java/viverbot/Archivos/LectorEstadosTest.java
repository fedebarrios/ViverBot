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
	
	@Test (expected = Exception.class)
	public void testArchivoNoTxt() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/File.notxt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("La extension del archivo no es .txt."));
		clear();
	}

	@Test (expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception
	{	
		inicialize("src/test/java/viverbot/Archivos/FixleDoxsEstadxxosMenoxs.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("No existe archivo"));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoConMenosLineas() throws Exception
	{	
		inicialize("src/test/java/viverbot/Archivos/FileCon2Lineas.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("El archivo debe contener 3 renglones"));
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
		lector = new LectorEstados();
		lector.leerArchivo(archivo);
	}

	private void clear() {
	}

}
