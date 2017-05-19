package viverbot.Archivos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class CreacionSelectorEstadosPorValorTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	PluginArchivos plugin;

	public void testArchivoArreglosIgualTamaño()
	{
		try{
			inicialize("src/test/java/viverbot/Archivos/FileIgualdad.txt");
		}
		catch (Exception ex){
			assertThat(ex.getMessage(), containsString("El tamaño del arreglo de estados debe ser mayor en 1 al de valores."));
		}
		clear();
	}
	
	public void testArchivoArregloValoresMasGrande()
	{
		try{
			inicialize("src/test/java/viverbot/Archivos/FileValoresMasGrande.txt");
		}
		catch (Exception ex){
			assertThat(ex.getMessage(), containsString("El tamaño del arreglo de estados debe ser mayor en 1 al de valores."));
		}
		clear();
	}
	
	public void testArchivoDosEstadosMenosQueValores()
	{
		try{
			inicialize("src/test/java/viverbot/Archivos/FileDosEstadosMenos.txt");
		}
		catch (Exception ex){
			assertThat(ex.getMessage(), containsString("El tamaño del arreglo de estados debe ser mayor en 1 al de valores."));
		}
		clear();
	}
	
	public void testArchivoDosEstadosMasQueValores()
	{
		try{
			inicialize("src/test/java/viverbot/Archivos/FileDosEstadosMas.txt");
		}
		catch (Exception ex){
			assertThat(ex.getMessage(), containsString("El tamaño del arreglo de estados debe ser mayor en 1 al de valores."));
		}
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
