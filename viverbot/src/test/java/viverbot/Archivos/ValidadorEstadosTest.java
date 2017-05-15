package viverbot.Archivos;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

public class ValidadorEstadosTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	PluginArchivos plugin;
	
	@Test
	public void testArchivoValoresNoNumericos() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileNoNumerico.txt");
		assertThat(outContent.toString(), containsString("Ingreso un valor que no es numerico para la lista de valores."));
		clear();
	}
	
	@Test
	public void testArchivoNombresIncorrectos() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileNombresIncorrectos.txt");
		assertThat(outContent.toString(), containsString("Ingreso un nombre con caracteres no alfanumericos."));
		clear();
	}
	
	@Test
	public void testArchivoArreglosIgualTamaño() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileIgualdad.txt");
		assertThat(outContent.toString(), containsString("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test
	public void testArchivoArregloValoresMasGrande() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileValoresMasGrande.txt");
		assertThat(outContent.toString(), containsString("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test
	public void testArchivoDosEstadosMenosQueValores() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileDosEstadosMenos.txt");
		assertThat(outContent.toString(), containsString("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test
	public void testArchivoDosEstadosMasQueValores() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileDosEstadosMas.txt");
		assertThat(outContent.toString(), containsString("La cantidad de valores debe ser menor en uno a la cantidad de estados."));
		clear();
	}
	
	@Test
	public void testArchivoOK() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		assertThat(outContent.toString(), containsString(""));
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
