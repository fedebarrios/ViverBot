package com.losameos.viverbot.Model.WebCam;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverobot.Model.WebCam.ImagenPlanta;
import com.losameos.viverobot.Model.WebCam.UbicacionImagen;

public class ImagenPlantaTest {
	
	private ImagenPlanta plantaImagen;
	@Test
	public void testLecturaDeImagen() {
		inicializar("arbol 4.png");
		clear();
	}
	
	@Test
	public void testGeters()
	{
		inicializar("arbol 4.png");
		System.out.println("ancho de imagen: "+plantaImagen.getAncho());
		System.out.println("alto de imagen: "+plantaImagen.getAlto());
		assertTrue(plantaImagen.getAtributos().getBuffer().getWidth()==plantaImagen.getAncho());
		assertTrue(plantaImagen.getAtributos().getBuffer().getHeight()==plantaImagen.getAlto());
		clear();
	}
	
	private void clear() {
		plantaImagen = null;
	}

	private void inicializar(String imagen)
	{
		UbicacionImagen ubicacion = new UbicacionImagen("/Users/Pandari/Desktop/ViverBot/viverbot/src/test/java/com/losameos/viverbot/Model/WebCam/"+imagen);
		plantaImagen = new ImagenPlanta();
		plantaImagen.LeerImagen(ubicacion);
	}

}
