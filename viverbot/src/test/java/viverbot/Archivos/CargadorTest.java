package viverbot.Archivos;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import viverbot.Model.HistorialOptimo;

public class CargadorTest {
	CargadorArchivos plugin ;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	//Aqui empiezan los test relacionados a historiales
	@Test
	public void cargarHistorial() throws Exception{
		inicialize();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/Historial.txt");
		assertEquals("zanahoria",h.getEspecie().getNombre());
		assertTrue( 2.44 == h.buscarTupla(2).getAltura().getValor());
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void cargaFallidaHistorialInconsistente() throws Exception{
		inicialize();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialNoConsistente.txt");
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void FaltaInfoEspecie() throws Exception{
		inicialize();
		HistorialOptimo h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialSinInfoEspecie.txt");
	}
	
	@Test
	public void levantarHistoriales(){
		inicialize();
		assertEquals(0,plugin.levantarArchivos("src/test/java/viverbot/Archivos/DirectorioTest1").size());
		assertEquals(2,plugin.levantarArchivos("src/test/java/viverbot/Archivos/DirectorioTest2").size());
		assertEquals(1,plugin.levantarArchivos("src/test/java/viverbot/Archivos/DirectorioTest3").size());
	}
	
	@Test
	public void elegirMejorDirectorio(){
		inicialize();
		String[] directorios = {"src/test/java/viverbot/Archivos/DirectorioTest1",
								"src/test/java/viverbot/Archivos/DirectorioTest2",
								"src/test/java/viverbot/Archivos/DirectorioTest3"};
		int i = 1;
		for(String s:directorios){
			GatewayConfiguracion.setearDirectorio(s, i);
			i++;
		}
		assertEquals(2,plugin.seleccionarMejorDirectorio().size());
	}
	
	//Aqui terminan los test relacionados a historiales
	
	public void inicialize(){
		plugin = new CargadorArchivos();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

}