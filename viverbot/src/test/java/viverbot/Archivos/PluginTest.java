package viverbot.Archivos;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.HistorialOptimo;

public class PluginTest {
	
	@Test
	public void cargarHistorial(){
		PluginArchivos plugin = new PluginArchivos();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/Historial.txt");
		assertEquals("zanahoria",h.getEspecie().getNombre());
		assertTrue( 2.44 == h.buscarTupla(2).getAltura().getValor());
		assertNotNull(h);
	}
	
	@Test
	public void cargaFallidaHistorial(){
		PluginArchivos plugin = new PluginArchivos();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialNoConsistente.txt");
		assertNull(h);
	}

}
