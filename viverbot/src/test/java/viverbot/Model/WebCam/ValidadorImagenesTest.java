package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

import viverbot.Modelo.WebCam.GeneradorImagen;
import viverbot.Modelo.WebCam.ValidadorImagenes;

public class ValidadorImagenesTest {
	
	private BufferedImage primerPath;
	private BufferedImage segundoPath;
	
	@Test
	public void testRealizarCargaValida() {
		
		inicializarPath("arbol 2.JPG", "arbol 4.png");
		assertTrue(ValidadorImagenes.validarTamañoImagen(primerPath, segundoPath));
	}
	
	@Test
	public void testDistintasResoluciones()
	{
		inicializarPath("arbol 2.JPG", "naranja.png");
		assertFalse(ValidadorImagenes.validarTamañoImagen(primerPath, segundoPath));
	}
	
	

	
	public void inicializarPath(String path1, String path2)
	{
		primerPath = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/"+path1);
		segundoPath = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/"+path2);
	
		
	}
	


}
