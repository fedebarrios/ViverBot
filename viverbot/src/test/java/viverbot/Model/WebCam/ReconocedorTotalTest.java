package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import org.junit.Test;

import viverbot.Modelo.WebCam.ComparadorKernel;
import viverbot.Modelo.WebCam.GeneradorImagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;

public class ReconocedorTotalTest {
	
	private ComparadorKernel comparador;
	private Kernel kernel;
	private BufferedImage imagenPlanta; 
	
	@Test
	public void detectar4Frutostest() {
		 imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/4objetos.png");
		 iniciarKernel();
		 ArrayList<Point> posicionesFrutos = reconocerFrutos(imagenPlanta,kernel,1,1);
		 assertTrue(new Point(1,1).equals(posicionesFrutos.get(0)));
		 assertTrue(new Point(13,8).equals(posicionesFrutos.get(1)));
		 assertTrue(new Point(4,15).equals(posicionesFrutos.get(2)));
		 assertTrue(new Point(21,20).equals(posicionesFrutos.get(3)));

	}
	

	@Test
	public void noDetectarFrutotest() {
		imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/vacio30x30.jpg");
		 iniciarKernel();
		 ArrayList<Point> posicionesFrutos = reconocerFrutos(imagenPlanta,kernel,1,1);
		 assertTrue(posicionesFrutos.isEmpty());

	}
	
	
	@Test
	public void deteccionObjetoBasuratest() {
		imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/6objetosYbasura.png");
		 iniciarKernel();
		 ArrayList<Point> posicionesFrutos = reconocerFrutos(imagenPlanta,kernel,1,1);
		 assertTrue(new Point(3,2).equals(posicionesFrutos.get(0)));
		 assertTrue(new Point(21,2).equals(posicionesFrutos.get(1)));
		 assertTrue(new Point(8,9).equals(posicionesFrutos.get(2)));
		 assertTrue(new Point(18,16).equals(posicionesFrutos.get(3)));
		 assertTrue(new Point(5,23).equals(posicionesFrutos.get(4)));
		 assertTrue(new Point(21,25).equals(posicionesFrutos.get(5)));


	}
	

	
	
	@Test
	public void desplazamientoPorPixelTest() {
		imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/4objetos.png");
		iniciarKernel();
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		Integer desplazamientoKernel = recoFalso.reconocerFrutos(imagenPlanta, kernel,0,0);
		assertEquals(1,desplazamientoKernel.intValue());

	}
	
	
	@Test
	public void desplazamientoPorBloqueTest() {
		imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/4objetos.png");
		iniciarKernel();
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		Integer desplazamientoKernel = recoFalso.reconocerFrutos(imagenPlanta, kernel,1,1);
		assertEquals(3,desplazamientoKernel.intValue());
	}
	
	
	
	@Test
	public void detectar4de2tamañosTest()
	{

		imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/4objetos2tipos40x40.png");
		iniciarKernelProporcion();
		ReconocedorFruto reconocedor = new ReconocedorFruto();	
		assertEquals(4,reconocedor.reconocerFrutos(imagenPlanta, kernel,0.5f,1).intValue());
		
	}
	
	
	@Test
	public void detectar3de3tamañosTest()
	{
		imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/6objetos3tipos.png");
		iniciarKernelProporcion();
		ReconocedorFruto reconocedor = new ReconocedorFruto();	
		assertEquals(5,reconocedor.reconocerFrutos(imagenPlanta, kernel,0.4f,1).intValue());
		
	}
	
	
	
	private void iniciarKernel() {
		 comparador = new ComparadorKernel();
		 String path = "src/test/java/viverbot/recursosTest/objeto1px.png";
		 BufferedImage kern = GeneradorImagen.generarImagen(path);
		 comparador.compararKernel(kern,imagenPlanta);
		 kernel = new Kernel(comparador.getWidth(),comparador.getHeight(),comparador.getDatos());		
	}
	
	private void iniciarKernelProporcion() {
		 comparador = new ComparadorKernel();
		 String path = "src/test/java/viverbot/recursosTest/objeto10x10.png";
		 BufferedImage kern = GeneradorImagen.generarImagen(path);
		 comparador.compararKernel(kern,imagenPlanta);
		 kernel = new Kernel(comparador.getWidth(),comparador.getHeight(),comparador.getDatos());		
	}
	
	private ArrayList<Point> reconocerFrutos(BufferedImage imagenPlanta2, Kernel kernel2, int i, int j) {
		 ReconocedorFruto reconocedor = new ReconocedorFruto();
		 reconocedor.reconocerFrutos(imagenPlanta, kernel,1,1);
		 return reconocedor.getUbicaciones();
	}


	

}
