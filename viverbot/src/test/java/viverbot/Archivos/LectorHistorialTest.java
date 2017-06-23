package viverbot.Archivos;
import org.junit.Test;

public class LectorHistorialTest {
	CargadorArchivos cargador = new CargadorArchivos();
	
	@Test (expected = Exception.class)
	public void testLecturaFallida() throws Exception
	{
		cargador.cargarHistorial("src/test/java/viverbot/Archivos/Historial.doc");
	}
	
	@Test
	public void testLecturaExitosa() throws Exception
	{
		cargador.cargarHistorial("src/test/java/viverbot/Archivos/Historial.txt");	
	}
}
