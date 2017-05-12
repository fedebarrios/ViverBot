package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SeparadorTest {
	Separador parser;
	
	@Test
	public void testSepararEntradas(){
		inicialize();
		List<String> entradas = parser.separarEntradas("14:4/15:47/47:69/");
		assertEquals(3 , entradas.size());
		assertEquals("14:4" , entradas.get(0));
	}
	
	@Test
	public void testSepararDatos(){
		inicialize();
		String[] casos =  {"16:54:4" , "16:4" , "14" , ""};
		String[] datos1 = parser.separarDato(casos[0]);
		String[] datos2 = parser.separarDato(casos[1]);
		String[] datos3 = parser.separarDato(casos[2]);
		String[] datos4 = parser.separarDato(casos[3]);
		assertEquals( 3, datos1.length);
		assertEquals( 2, datos2.length);
		assertEquals( 1, datos3.length);
		assertEquals( 1, datos4.length);
	}
	
	public void inicialize(){
		parser = new Separador();
	}
}
