package viverbot.Controlador.Verificacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VerificadorTest {
	Verificador verificador;
	
	@Test
	public void validarExistencia(){
		inicialize();
		assertTrue(Verificador.validarExistencia("src/test/java/viverbot/Archivos/File.notxt"));
		assertFalse(Verificador.validarExistencia("src/test/java/viverbot/Archivos/File.n"));
	}
	
	@Test
	public void validarExtension(){
		inicialize();
		assertTrue(Verificador.validarExtension("src/test/java/viverbot/Archivos/File.notxt","notxt"));
		assertFalse(Verificador.validarExtension("src/test/java/viverbot/Archivos/File.n","txt"));
	}

	public void inicialize(){
		verificador = new Verificador();
	}
}
