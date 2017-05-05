package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.WebCam.ValidadorSeleccion;

public class ValidadorSeleccionTest {

	@Test
	public void testSeleccionarOpcion() {
		assertFalse(ValidadorSeleccion.validarOpcion(1));
		assertTrue(ValidadorSeleccion.validarOpcion(0));
		assertFalse(ValidadorSeleccion.validarOpcion(3));
	}
	
	@Test
	public void testValidarExtencion()
	{
		assertTrue(ValidadorSeleccion.validarExtencion("arbol.jpg"));
		assertTrue(ValidadorSeleccion.validarExtencion("arbol.JPG"));
		assertTrue(ValidadorSeleccion.validarExtencion("arbol.png"));
		assertTrue(ValidadorSeleccion.validarExtencion("arbol.PNG"));
		assertTrue(ValidadorSeleccion.validarExtencion("arbol.BMP"));
		assertTrue(ValidadorSeleccion.validarExtencion("arbol.bmp"));
		assertFalse(ValidadorSeleccion.validarExtencion("arbol.html"));
		assertFalse(ValidadorSeleccion.validarExtencion("arbol.mp3"));
		assertFalse(ValidadorSeleccion.validarExtencion("arbol.xml"));
		assertFalse(ValidadorSeleccion.validarExtencion("arbol.mp4"));

	}
	
	@Test
	public void testPathSeleccionado()
	{
		assertTrue(ValidadorSeleccion.validarPathSeleccionado(""));
		assertFalse(ValidadorSeleccion.validarPathSeleccionado("arbol.jpg"));
	}
	
	
}
