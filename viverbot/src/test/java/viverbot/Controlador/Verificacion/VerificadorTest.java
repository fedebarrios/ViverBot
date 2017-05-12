package viverbot.Controlador.Verificacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import viverbot.Archivos.Validador;

public class VerificadorTest {
	Verificador verificador;
	
	@Test
	public void validarExistencia(){
		inicialize();
		assertTrue(verificador.validarExistencia("src/test/java/viverbot/Archivos/File.notxt"));
		assertFalse(verificador.validarExistencia("src/test/java/viverbot/Archivos/File.n"));
	}
	
	@Test
	public void validarExtension(){
		inicialize();
		assertTrue(verificador.validarExtension("src/test/java/viverbot/Archivos/File.notxt","notxt"));
		assertFalse(verificador.validarExtension("src/test/java/viverbot/Archivos/File.n","txt"));
	}
	
	/*
	@Test
	public void validarDatosNumericos(){
		inicialize();
		String[] datos1 = {"45","14"};
		String[] datos2 = {"45o","14"};
		String[] datos3 = {"45o","14k"};
		assertTrue(verificador.validarDatosNumericosHistorial(datos1));
		assertFalse(verificador.validarDatosNumericosHistorial(datos2));
		assertFalse(verificador.validarDatosNumericosHistorial(datos3));
	}
	
	@Test
	public void validarCantidadDatosExacta(){
		inicialize();
		String[] datos1 = {"45"};
		String[] datos2 = {"45","14"};
		String[] datos3 = {"45","14","65"};
		assertFalse(verificador.validarCantidadDatosHistorial(datos1));
		assertTrue(verificador.validarCantidadDatosHistorial(datos2));
		assertFalse(verificador.validarCantidadDatosHistorial(datos3));
	}*/
	
	public void inicialize(){
		verificador = new Verificador();
	}
}
