package viverbot.Archivos;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import junit.framework.TestCase;
import viverbot.Controlador.Verificacion.EstadoAltura;

public class ParserArchivosTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
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
	
	@Test
	public void testArchivoOK() throws Exception
	{
		inicialize("src/test/java/viverbot/Archivos/FileEstadosMasGrande.txt");
		String msjLog = outContent.toString();
		assertNotNull(msjLog);
		assertTrue(msjLog.contains(""));
		clear();
	}
	
	@SuppressWarnings("unused")
	private void inicialize(String archivo) throws Exception{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		LectorTxt lector = new LectorTxt();
		String lectura = lector.leerTxt(archivo);
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		Integer codigoEspecie = parser.parsearCodigoEspecie(lectura);
	}

	private void clear() {
	}

}
