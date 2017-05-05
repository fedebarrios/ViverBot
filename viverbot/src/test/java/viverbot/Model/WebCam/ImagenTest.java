package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.WebCam.Imagen;

public class ImagenTest {
	
	private Imagen plantaImagen;
	@Test
	public void testLecturaDeImagen() {
		inicializar("arbol 4.png");
		clear();
	}
	
	private void clear() {
		plantaImagen = null;
	}

	private void inicializar(String imagen)
	{
		String ubicacion = "src/test/java/viverbot/recursosTest/"+imagen;
		plantaImagen = new Imagen(ubicacion);
		
	}

}
