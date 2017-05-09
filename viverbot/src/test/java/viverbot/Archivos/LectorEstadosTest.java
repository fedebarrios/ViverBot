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
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoNoTxt()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/File.notxt");
		assertThat(outContent.toString(), containsString("El formato del archivo no es .txt."));
		clear();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoValoresNoNumericos()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/FileNoNumerico.txt");
		assertThat(outContent.toString(), containsString("Ingreso un valor que no es numerico para la lista de valores."));
		clear();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoNombresIncorrectos()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/FileNombresIncorrectos.txt");
		assertThat(outContent.toString(), containsString("Ingreso un nombre con caracteres no alfanumericos."));
		clear();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoArreglosIgualTamaño()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/FileIgualdad.txt");
		assertThat(outContent.toString(), containsString("La cantidad de estados debe ser menor en uno a la cantidad de valores."));
		clear();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoArregloEstadosMasGrande()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		assertThat(outContent.toString(), containsString("La cantidad de estados debe ser menor en uno a la cantidad de valores."));
		clear();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoDosEstadosMenosQueValores()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/FileDosEstadosMenos.txt");
		assertThat(outContent.toString(), containsString("La cantidad de estados debe ser menor en uno a la cantidad de valores."));
		clear();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArchivoNoEncontrado()
	{
		inicialize();
		lector.leerArchivo("src/test/java/viverbot/Archivos/FixleDoxsEstadxxosMenoxs.txt");
		assertThat(outContent.toString(), containsString("Archivo no encontrado."));
		clear();
	}
	
	private void inicialize() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	private void clear() {
	}

}
