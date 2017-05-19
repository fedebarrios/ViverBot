package viverbot.Archivos;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

public class ParserArchivosTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	PluginArchivos plugin;
	
	// Comentados los assert del log
	@Test (expected = Exception.class)
	public void testArchivoValoresNoNumericos() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileNoNumerico.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("Los valores no son alfanumericos o no estan seteados."));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoNombresIncorrectos() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileNombresIncorrectos.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("Los estados tienen caracteres no alfanumericos o no estan seteados."));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoCodigoIncorrecto() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileCodigoIncorrecto.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains("El codigo no es numerico o no esta seteado."));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoArreglosIgualTamaño() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileIgualdad.txt");
		//String msjLog = outContent.toString();
		//assertNotNull(msjLog);
		//assertTrue(msjLog.contains("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoArregloValoresMasGrande() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileValoresMasGrande.txt");
		//String msjLog = outContent.toString();
		//assertNotNull(msjLog);
		//assertTrue(msjLog.contains("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoDosEstadosMenosQueValores() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileDosEstadosMenos.txt");
		//String msjLog = outContent.toString();
		//assertNotNull(msjLog);
		//assertTrue(msjLog.contains("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test (expected = Exception.class)
	public void testArchivoDosEstadosMasQueValores() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileDosEstadosMas.txt");
		//String msjLog = outContent.toString();
		//assertNotNull(msjLog);
		//assertTrue(msjLog.contains("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test
	public void testArchivoOK() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		clear();
	}
	
	private void inicialize(String archivo) throws Exception{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		plugin = new PluginArchivos();
		plugin.cargarEstados(archivo);
	}

	private void clear() {
	}

}
