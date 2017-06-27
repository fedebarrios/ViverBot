package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

import viverbot.Modelo.WebCam.GeneradorImagen;
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class ResaltadorImagenTest {

	
	private BufferedImage primerImg;
	private BufferedImage segundaImg;
	@Test
	public void test() {
		inicializarImagenes();
		ResaltadorImagen.resaltarImagen(primerImg, segundaImg, 0, 0);
	}
	
	public void inicializarImagenes()
	{
		 primerImg = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/arbol.JPG");
		 segundaImg = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/arbolC.png");


	}

}
