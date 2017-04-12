package com.losameos.viverbot.Model.WebCam;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.losameos.viverobot.Model.WebCam.AtributosImagen;

public class AtributosImagenTest {

	private AtributosImagen atributos;
	@Test
	public void testIniciarBuffer() {
		inicializar("arbol 4.png");
		clear();
	}
	
	@Test
	public void testIniciarRGB() {
		inicializar("arbol 4.png");
		System.out.println("ancho: "+atributos.getBuffer().getWidth());
		System.out.println("alto: "+atributos.getBuffer().getHeight());
		atributos.iniRGB(100, 100);
		
		//Asumiendo que se levanta la imagen arbol 4.png
		assertTrue(atributos.getCanalAzul()==255);
		assertTrue(atributos.getCanalRojo()==255);
		assertTrue(atributos.getCanalVerde()==255);
		//Se reemplaza la foto por otra que contiene un pixel seteado con valor 0.
		inicializar("miNaranja.png");
		atributos.iniRGB(100, 100);
		assertFalse(atributos.getCanalAzul()==255);
		assertFalse(atributos.getCanalRojo()==255);
		assertFalse(atributos.getCanalVerde()==255);
		
		clear();
	}
	
	@Test
	public void testModificarRGB()
	{
		inicializar("arbol.jpg");
		atributos.iniRGB(100, 100);
		System.out.println("Azul: "+atributos.getCanalAzul());
		System.out.println("Verde: "+atributos.getCanalVerde());
		System.out.println("Rojo: "+atributos.getCanalRojo());
		atributos.setCanalAzul(120);
		atributos.setCanalRojo(140);
		atributos.setCanalVerde(160);
		assertTrue(atributos.getCanalAzul()==120);
		assertTrue(atributos.getCanalRojo()==140);
		assertTrue(atributos.getCanalVerde()==160);
		
		
	}
	
	private void inicializar(String direccion)
	{
		String ubicacion = "/Users/Pandari/Desktop/ViverBot/viverbot/src/test/java/com/losameos/viverbot/Model/WebCam/"+direccion;
		atributos = new AtributosImagen();
		atributos.iniBuffer(new File(ubicacion));
	}

	private void clear()
	{
		atributos = null;
	}
}
