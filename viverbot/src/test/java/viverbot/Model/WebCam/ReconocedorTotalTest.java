package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class ReconocedorTotalTest {
	
	private AdapterImage adaptador;
	private ReconocedorFruto reconocedor;
	private Kernel kernel;
	private Imagen imagenPlanta; 
	
	@Test
	public void detectar4Frutostest() {
		 imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/4objetos.png");
		 iniciarKernel();
		 reconocedor = new ReconocedorFruto();	
		 assertEquals(4,reconocedor.reconocerFrutos(imagenPlanta, kernel,1,1).intValue());
	}
	
	@Test
	public void noDetectarFrutotest() {
		imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/vacio30x30.jpg");
		 iniciarKernel();
		 reconocedor = new ReconocedorFruto();	
		 assertEquals(0,reconocedor.reconocerFrutos(imagenPlanta, kernel,1,1).intValue());

	}
	
	
	@Test
	public void deteccionObjetoBasuratest() {
		imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/6objetosYbasura.png");
		 iniciarKernel();
		 reconocedor = new ReconocedorFruto();	
		 assertEquals(6,reconocedor.reconocerFrutos(imagenPlanta, kernel,1,1).intValue());


	}
	
	
	
	
	@Test
	public void desplazamientoPorPixelTest() {
		imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/4objetos.png");
		iniciarKernel();
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		Integer desplazamientoKernel = recoFalso.reconocerFrutos(imagenPlanta, kernel,0,0);
		assertEquals(1,desplazamientoKernel.intValue());

	}
	
	
	@Test
	public void desplazamientoPorBloqueTest() {
		imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/4objetos.png");
		iniciarKernel();
		ReconocedorFrutoMock recoFalso = new ReconocedorFrutoMock();
		Integer desplazamientoKernel = recoFalso.reconocerFrutos(imagenPlanta, kernel,1,1);
		assertEquals(3,desplazamientoKernel.intValue());
	}
	
	
	
	@Test
	public void detectar4de2tamañosTest()
	{

		imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/4objetos2tipos40x40.png");
		iniciarKernelProporcion();
		reconocedor = new ReconocedorFruto();	
		assertEquals(4,reconocedor.reconocerFrutos(imagenPlanta, kernel,0.5f,1).intValue());
		
	}
	
	
	@Test
	public void detectar3de3tamañosTest()
	{
		imagenPlanta = new Imagen("src/test/java/viverbot/recursosTest/6objetos3tipos.png");
		iniciarKernelProporcion();
		reconocedor = new ReconocedorFruto();	
		assertEquals(6,reconocedor.reconocerFrutos(imagenPlanta, kernel,0.5f,1).intValue());
		
	}
	
	
	
	private void iniciarKernel() {
		 adaptador = new AdapterImage();
		 adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objeto1px.png",imagenPlanta);
		 kernel = new Kernel(adaptador.getWidth(),adaptador.getHeight(),adaptador.getDatos());		
	}
	
	private void iniciarKernelProporcion() {
		 adaptador = new AdapterImage();
		 adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objeto10x10.png",imagenPlanta);
		 kernel = new Kernel(adaptador.getWidth(),adaptador.getHeight(),adaptador.getDatos());		
	}
	
	

	

}
