package viverbot.Archivos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidadorTest {
	Validador validador;
	
	@Test
	public void validarExistencia(){
		inicialize();
		assertTrue(validador.validarExistencia("src/test/java/viverbot/Archivos/File.notxt"));
		assertFalse(validador.validarExistencia("src/test/java/viverbot/Archivos/File.n"));
	}
	
	@Test
	public void validarExtension(){
		inicialize();
		assertTrue(validador.validarExtension("src/test/java/viverbot/Archivos/File.notxt","notxt"));
		assertFalse(validador.validarExtension("src/test/java/viverbot/Archivos/File.n","txt"));
	}
	
	public void inicialize(){
		validador = new Validador();
	}
}
