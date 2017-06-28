package viverbot.Archivos;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.HistorialIdeal;

public class CargadorTest {
	CargadorArchivos plugin ;
	@Test
	public void cargarHistorial() throws Exception{
		inicialize();
		HistorialIdeal h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/Historial.txt");
		assertEquals("zanahoria",h.getEspecie().getNombre());
		assertTrue( 2.44 == h.buscarMedicion(2).getValor());
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void cargaFallidaHistorialInconsistente() throws Exception{
		inicialize();
		HistorialIdeal h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialNoConsistente.txt");
	}
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void FaltaInfoEspecie() throws Exception{
		inicialize();
		HistorialIdeal h = plugin.cargarHistorial("src/test/java/viverbot/Archivos/HistorialSinInfoEspecie.txt");
	}
	
	@Test
	public void levantarHistoriales(){
		inicialize();
		assertEquals(0,plugin.levantarArchivos("src/test/java/viverbot/Archivos/DirectorioTest1").size());
		assertEquals(2,plugin.levantarArchivos("src/test/java/viverbot/Archivos/DirectorioTest2").size());
		assertEquals(1,plugin.levantarArchivos("src/test/java/viverbot/Archivos/DirectorioTest3").size());
	}
	
	@Test
	public void elegirPrimerDirectorioConArchivosParaLevantar(){
		inicialize();
		GatewayConfiguracion.limpiar();
		String[] directorios = {"src/test/java/viverbot/Archivos/DirectorioTest1",
								"src/test/java/viverbot/Archivos/DirectorioTest2",
								"src/test/java/viverbot/Archivos/DirectorioTest3"};
		int i = 1;
		for(String s:directorios){
			GatewayConfiguracion.agregarDirectorio(s);
			i++;
		}
		assertEquals(2,plugin.seleccionarMejorDirectorio().size());
	}
		
	public void inicialize(){
		plugin = new CargadorArchivos();
	}

}
