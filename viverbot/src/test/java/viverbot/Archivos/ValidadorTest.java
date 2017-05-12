package viverbot.Archivos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ValidadorTest {
	ValidadorHistorial validador;
	
	
	@Test
	public void validarDatosNumericos(){
		inicialize();
		String[] datos1 = {"45","14"};
		String[] datos2 = {"45o","14"};
		String[] datos3 = {"45o","14k"};
		String[] datos4 = {"45.4","14.4"};
		assertTrue(validador.validarDatosNumericosHistorial(datos1));
		assertFalse(validador.validarDatosNumericosHistorial(datos2));
		assertFalse(validador.validarDatosNumericosHistorial(datos3));
		assertTrue(validador.validarDatosNumericosHistorial(datos4));
	}
	
	@Test
	public void validarCantidadDatosExacta(){
		inicialize();
		String[] datos1 = {"45"};
		String[] datos2 = {"45","14"};
		String[] datos3 = {"45","14","65"};
		assertFalse(validador.validarCantidadDatosHistorial(datos1));
		assertTrue(validador.validarCantidadDatosHistorial(datos2));
		assertFalse(validador.validarCantidadDatosHistorial(datos3));
	}
	
	@Test
	public void HistorialValido(){
		inicialize();
		String[] entradas = {"h54:65.0","h57:14.3","e65:47.9"};
		ArrayList<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertTrue(validador.validarHistorial(lectura));
	}
	
	public void inicialize(){
		validador = new ValidadorHistorial();
	}
}
