package viverbot.Model.WebCam;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;
import viverbot.Modelo.WebCam.ComparadorKernel;
import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.GeneradorImagen;
import viverbot.Modelo.WebCam.Kernel;

import viverbot.Modelo.WebCam.ValidadorKernel;

public class DetectorFrutoTest {
	
	private ComparadorKernel comparador;
	private Kernel kernel;
	private BufferedImage imagenPlanta;
	
	@Test
	public void kernelx1y1Test() {
		 imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/objeto(1,1).png");
		 iniciarKernel();
		 assertTrue(DetectorFruto.detectar(imagenPlanta, 1, 1, kernel));
	}
	
	@Test
	public void kernelx5y1Test() {
		 imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/objeto(1,1).png");
		 iniciarKernel();
		 assertFalse(DetectorFruto.detectar(imagenPlanta, 5, 1, kernel));
	}

	@Test
	public void kernelx1y1RecortadoTest() {
		 imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/objeto(1,1)Recortado.png");
		 iniciarKernel();
		 assertFalse(DetectorFruto.detectar(imagenPlanta, 1, 1, kernel));
	}
	
	@Test
	public void kernelSuperaDimensiones()throws Exception 
	{
		 imagenPlanta = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/objeto(1,1).png");
		 BufferedImage imagenKernel = GeneradorImagen.generarImagen("src/test/java/viverbot/recursosTest/objeto10x10.png");
		 ValidadorKernel validador = new ValidadorKernel(); 
		 validador.validarKernel(imagenKernel,imagenPlanta);
		
	}
	

	private void iniciarKernel() {
		 comparador = new ComparadorKernel();
		 String path = "src/test/java/viverbot/recursosTest/objeto1px.png";
		 BufferedImage ker = GeneradorImagen.generarImagen(path);
		 comparador.compararKernel(ker, imagenPlanta);
		 kernel = new Kernel(comparador.getWidth(),comparador.getHeight(),comparador.getDatos());		
	}
	
	
	

	}
