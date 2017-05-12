package viverbot.Archivos;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ValidadorHistorialTest {
	ValidadorHistorial validador;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	
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
		String[] entradas = {"h54:65.0","h57:14.3","etomate:tomatus"};
		ArrayList<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertTrue(validador.validarHistorial(lectura));
	}
	
	@Test
	public void HistorialInvalidoInfoNoNumerica(){
		inicialize();
		String[] entradas = {"hinfo:65.0","h57:14.3","etomate:tomatus"};
		ArrayList<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertFalse(validador.validarHistorial(lectura));
		assertThat(outContent.toString(), containsString("No se puede ingresar informacion que no sean numeros"));
	}
	
	@Test
	public void HistorialInvalidoMenorCantidadDatos(){
		inicialize();
		String[] entradas = {"h4:65.0","h57:","etomate:tomatus"};
		ArrayList<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertFalse(validador.validarHistorial(lectura));
		assertThat(outContent.toString(), containsString("Debe ingresar dos datos por fila"));
	}
	
	@Test
	public void HistorialConInfoDeEspecie(){
		inicialize();
		String[] entradas = {"h54:65.0","h57:14.3","epera:peral"};
		List<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertTrue(validador.validarInfoEspecie(lectura));
	}
	
	@Test
	public void HistorialSinInfoDeEspecie(){
		inicialize();
		String[] entradas = {"h54:65.0","h57:14.3","hberenjena:berenjenus"};
		List<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertFalse(validador.validarInfoEspecie(lectura));
	}
	
	@Test
	public void HistorialConMasDeUnaInfoDeEspecie(){
		inicialize();
		String[] entradas = {"h54:65.0","e57:14.3","etomate:tomatus"};
		List<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertFalse(validador.validarInfoEspecie(lectura));
	}
	
	@Test
	public void HistorialConFormatoExcesivoInfoDeEspecie(){
		inicialize();
		String[] entradas = {"h54:65.0","h57:14.3","etomate:pera:papa"};
		List<String> lectura = new ArrayList<String>();
		for(String s : entradas){
			lectura.add(s);
		}
		assertFalse(validador.validarInfoEspecie(lectura));
	}
	
	
	public void inicialize(){
		validador = new ValidadorHistorial();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
}
