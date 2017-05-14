package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.WebCam.ValidadorImagenes;

public class ValidadorImagenesTest {
	
	private String primerPath;
	private String segundoPath;
	
	@Test
	public void testRealizarCargaValida() {
		
		inicializarPath("arbol 2.JPG", "arbol 4.png");
		assertTrue(ValidadorImagenes.validarTamañoImagen(primerPath, segundoPath));
		clear();
	}
	
	@Test
	public void testDistintasResoluciones()
	{
		inicializarPath("arbol 2.JPG", "naranja.png");
		assertFalse(ValidadorImagenes.validarTamañoImagen(primerPath, segundoPath));
		clear();
	}
	
	

	
	public void inicializarPath(String path1, String path2)
	{
		primerPath = "src/test/java/viverbot/recursosTest/"+path1;
		segundoPath = "src/test/java/viverbot/recursosTest/"+path2;
	}
	
	public void clear()
	{
		primerPath = "";
		segundoPath = "";
	}

}
