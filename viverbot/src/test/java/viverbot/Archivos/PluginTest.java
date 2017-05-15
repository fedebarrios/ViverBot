package viverbot.Archivos;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import viverbot.Model.HistorialOptimo;

public class PluginTest {
	PluginArchivos plugin ;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Test
	public void cargarHistorial() throws Exception{
		inicialize();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/Historial.txt");
		assertEquals("zanahoria",h.getEspecie().getNombre());
		assertTrue( 2.44 == h.buscarTupla(2).getAltura().getValor());
		assertNotNull(h);
	}
	
	@Test
	public void cargaFallidaHistorial() throws Exception{
		inicialize();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialNoConsistente.txt");
		assertNull(h);
	}
	
	@Test
	public void FaltaInfoEspecie() throws Exception{
		inicialize();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialSinInfoEspecie.txt");
		assertNull(h);
		//assertThat(outContent.toString(), containsString("No existe informacion acerca de la especie"));
	}
	
	public void inicialize(){
		plugin = new PluginArchivos();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

}
