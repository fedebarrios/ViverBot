package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ParserTest {
	Parser parser;
	
	@Test
	public void testSepararEntradas(){
		inicialize();
		List<String> entradas = parser.separarEntradas("14:4/15:47/47:69");
		assertEquals(3 , entradas.size());
		assertEquals("14:4" , entradas.get(0));
	}
	
	public void inicialize(){
		parser = new Parser();
	}
}
