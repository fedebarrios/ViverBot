package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

public class LectorHistorialTest {
	CargadorArchivos cargador = new CargadorArchivos();
	
	@Test (expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception
	{
		cargador.cargarHistorial("src/test/java/viverbot/Archivos/Historial.t");
	}
	
	@Test (expected = Exception.class)
	public void testArchivoNoTxt() throws Exception
	{
		cargador.cargarHistorial("src/test/java/viverbot/Archivos/Historial.csb");
	}
	
	@Test
	public void testLecturaExitosa() throws Exception
	{
		cargador.cargarHistorial("src/test/java/viverbot/Archivos/Historial.txt");	
	}
	
	@Test
	public void test(){
		LectorArchivo l = new LectorArchivo();
		try {
			BufferedReader b = new BufferedReader(new FileReader("src/test/java/viverbot/Archivos/Historial.txt"));
			String s = "etiqueta";
			while(!s.equals("")){
				s=l.lecturaParcial(b);
				System.out.println(s);
			}
		}
		catch(Exception e){
		}
	}
}
